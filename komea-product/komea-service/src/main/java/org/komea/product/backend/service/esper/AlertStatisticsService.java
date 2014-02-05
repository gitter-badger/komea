/**
 * 
 */

package org.komea.product.backend.service.esper;



import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.komea.product.backend.api.IEsperEngine;
import org.komea.product.backend.esper.reactor.KPINotFoundException;
import org.komea.product.backend.esper.reactor.KPINotFoundRuntimeException;
import org.komea.product.backend.service.ISystemProjectBean;
import org.komea.product.backend.service.business.IKPIFacade;
import org.komea.product.backend.service.cron.ICronRegistryService;
import org.komea.product.backend.service.kpi.IEntityWithKPIAdapter;
import org.komea.product.backend.service.kpi.IKPIService;
import org.komea.product.database.dao.ProviderDao;
import org.komea.product.database.enums.EntityType;
import org.komea.product.database.model.Kpi;
import org.komea.product.database.model.Measure;
import org.komea.product.database.model.Project;
import org.komea.product.service.dto.AlertTypeStatistic;
import org.quartz.JobDataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espertech.esper.client.EPStatement;



/**
 * This service provides informations about the informations received by esper (number of alerts received per days, and alert type
 * breakdown);
 * 
 * @author sleroy
 */
@Service
public class AlertStatisticsService implements IAlertStatisticsService
{
    
    
    public static final String    ALERT_RECEIVED_IN_ONE_DAY = "ALERT_RECEIVED_IN_ONE_DAY";
    
    
    private static final String   STATS_BREAKDOWN_24H       = "STATS_BREAKDOWN_24H";
    
    
    private static final Logger   LOGGER                    =
                                                                    LoggerFactory
                                                                            .getLogger(AlertStatisticsService.class);
    
    
    @Autowired
    private IKPIService           kpiService;
    
    
    @Autowired
    private ISystemProjectBean    systemProject;
    
    
    @Autowired
    private IEntityWithKPIAdapter entityWithKPIAdapter;
    
    
    @Autowired
    IEsperEngine                  esperEngine;
    
    @Autowired
    private ProviderDao           providerDAO;
    
    
    @Autowired
    private ICronRegistryService  registry;
    
    
    
    /**
     * 
     */
    public AlertStatisticsService() {
    
    
        super();
    }
    
    
    @Override
    public List<Measure> getAllMeasures() {
    
    
        try {
            final List<Measure> history =
                    kpiService.findKPIFacade(systemProject.getSystemProject(),
                            ALERT_RECEIVED_IN_ONE_DAY).getHistory();
            LOGGER.info("History of alerts {}", history.size());
            return history;
        } catch (final KPINotFoundException e) {
            LOGGER.error("KPI is not initialized to obtain statistics", e);
            return Collections.EMPTY_LIST;
        }
    }
    
    
    /**
     * @return the entityWithKPIAdapter
     */
    public final IEntityWithKPIAdapter getEntityWithKPIAdapter() {
    
    
        return entityWithKPIAdapter;
    }
    
    
    /**
     * @return the esperEngine
     */
    public final IEsperEngine getEsperEngine() {
    
    
        return esperEngine;
    }
    
    
    public IKPIService getKpiService() {
    
    
        return kpiService;
    }
    
    
    public ProviderDao getProviderDAO() {
    
    
        return providerDAO;
    }
    
    
    @Override
    public long getReceivedAlertsIn24LastHours() {
    
    
        try {
            final IKPIFacade<Project> findKPIFacade =
                    kpiService.findKPIFacade(systemProject.getSystemProject(),
                            ALERT_RECEIVED_IN_ONE_DAY);
            return findKPIFacade.getMetric().getIntValue();
        } catch (final KPINotFoundException e) {
            throw new KPINotFoundRuntimeException(systemProject.getSystemProject(),
                    ALERT_RECEIVED_IN_ONE_DAY, e);
        }
        
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.service.esper.IAlertStatisticsService#getReceivedAlertTypesIn24Hours()
     */
    @Override
    public List<AlertTypeStatistic> getReceivedAlertTypesIn24LastHours() {
    
    
        final EPStatement statsBreakdownStatement = esperEngine.getStatement(STATS_BREAKDOWN_24H);
        return EPStatementResult.build(statsBreakdownStatement).listMapResult(
                AlertTypeStatistic.class);
    }
    
    
    public ICronRegistryService getRegistry() {
    
    
        return registry;
    }
    
    
    /**
     * @return the systemProject
     */
    public final ISystemProjectBean getSystemProject() {
    
    
        return systemProject;
    }
    
    
    @PostConstruct
    public void init() {
    
    
        LOGGER.info("Creating System KPI for statistics...");
        Kpi kpi = kpiService.findKPI(systemProject.getSystemProject(), ALERT_RECEIVED_IN_ONE_DAY);
        if (kpi == null) {
            
            
            kpi = new Kpi();
            kpi.setDescription("Provides the number of alerts received under 24 hours");
            kpi.setEntityType(EntityType.PROJECT);
            
            kpi.setEsperRequest("SELECT COUNT(*) as alert_number FROM Alert.win:time(24 hour)");
            kpi.setKpiKey(ALERT_RECEIVED_IN_ONE_DAY);
            kpi.setMinValue(0d);
            kpi.setMaxValue(Double.MAX_VALUE);
            kpi.setName("Number of alerts received under 24 hours.");
            kpi.setEntityID(systemProject.getSystemProject().getId());
            kpi.setCronExpression("0/5 * * * * ?");
            final List<Kpi> listOfKpisOfEntity =
                    kpiService.getListOfKpisOfEntity(systemProject.getSystemProject());
            listOfKpisOfEntity.add(kpi);
            kpiService.updateKPIOfEntity(systemProject.getSystemProject(), listOfKpisOfEntity);
            
        } else {
            LOGGER.info("Statistics KPI already existing.");
        }
        
        kpiService.synchronizeEntityWithKomea(systemProject.getSystemProject());
        esperEngine.createOrUpdateEPL(new QueryDefinition(
                "SELECT DISTINCT provider, type, count(*) as number FROM Alert.win:time(24 hour)",
                STATS_BREAKDOWN_24H));
        scheduleAlerts();
        
    }
    
    
    public void scheduleAlerts() {
    
    
        final JobDataMap properties = new JobDataMap();
        properties.put("esper", esperEngine);
        registry.registerCronTask("ALERT_DEMO_STAT", "0/1 * * * * ?", AlertJobDemo.class,
                properties);
        
        
    }
    
    
    /**
     * @param _entityWithKPIAdapter
     *            the entityWithKPIAdapter to set
     */
    public final void setEntityWithKPIAdapter(final IEntityWithKPIAdapter _entityWithKPIAdapter) {
    
    
        entityWithKPIAdapter = _entityWithKPIAdapter;
    }
    
    
    /**
     * @param _esperEngine
     *            the esperEngine to set
     */
    public final void setEsperEngine(final IEsperEngine _esperEngine) {
    
    
        esperEngine = _esperEngine;
    }
    
    
    /**
     * @param _kpiService
     *            the kpiService to set
     */
    public final void setKpiService(final IKPIService _kpiService) {
    
    
        kpiService = _kpiService;
    }
    
    
    public void setProviderDAO(final ProviderDao _providerDAO) {
    
    
        providerDAO = _providerDAO;
    }
    
    
    public void setRegistry(final ICronRegistryService _registry) {
    
    
        registry = _registry;
    }
    
    
    /**
     * @param _systemProject
     *            the systemProject to set
     */
    public final void setSystemProject(final ISystemProjectBean _systemProject) {
    
    
        systemProject = _systemProject;
    }
}
