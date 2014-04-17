
package org.komea.product.backend.service.kpi;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.komea.eventory.api.engine.ICEPQuery;
import org.komea.eventory.api.formula.ICEPResult;
import org.komea.eventory.api.formula.ITupleResultMap;
import org.komea.product.backend.api.IEventEngineService;
import org.komea.product.backend.api.IKpiQueryRegisterService;
import org.komea.product.backend.api.IMeasureHistoryService;
import org.komea.product.backend.api.exceptions.EntityNotFoundException;
import org.komea.product.backend.api.exceptions.KpiAlreadyExistingException;
import org.komea.product.backend.criterias.FindKpi;
import org.komea.product.backend.criterias.FindKpiOrFail;
import org.komea.product.backend.exceptions.KPINotFoundException;
import org.komea.product.backend.genericservice.AbstractService;
import org.komea.product.backend.service.cron.ICronRegistryService;
import org.komea.product.backend.service.entities.IEntityService;
import org.komea.product.backend.service.history.HistoryKey;
import org.komea.product.backend.service.history.IHistoryService;
import org.komea.product.backend.utils.CollectionUtil;
import org.komea.product.database.api.IEntity;
import org.komea.product.database.dao.HasSuccessFactorKpiDao;
import org.komea.product.database.dao.IGenericDAO;
import org.komea.product.database.dao.KpiAlertTypeDao;
import org.komea.product.database.dao.KpiDao;
import org.komea.product.database.dao.ProjectDao;
import org.komea.product.database.dto.BaseEntityDto;
import org.komea.product.database.enums.EntityType;
import org.komea.product.database.model.HasSuccessFactorKpiCriteria;
import org.komea.product.database.model.HasSuccessFactorKpiKey;
import org.komea.product.database.model.Kpi;
import org.komea.product.database.model.KpiAlertType;
import org.komea.product.database.model.KpiAlertTypeCriteria;
import org.komea.product.database.model.KpiCriteria;
import org.komea.product.database.model.Measure;
import org.komea.product.database.model.MeasureCriteria;
import org.komea.product.database.model.SuccessFactor;
import org.komea.product.service.dto.EntityKey;
import org.komea.product.service.dto.KpiKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 */
@Service
@Transactional()
public final class KPIService extends AbstractService<Kpi, Integer, KpiCriteria> implements
        IKPIService
{
    
    
    private static final Logger      LOGGER = LoggerFactory.getLogger("kpi-service");
    
    @Autowired
    private KpiAlertTypeDao          alertDao;
    
    @Autowired
    private ICronRegistryService     cronRegistry;
    
    @Autowired
    private IEntityService           entityService;
    
    @Autowired
    private IEventEngineService      esperEngine;
    
    @Autowired
    private IKpiQueryRegisterService kpiQueryRegistry;
    
    @Autowired
    private IMeasureHistoryService   measureService;
    
    @Autowired
    private ProjectDao               projectDao;
    
    @Autowired
    private KpiDao                   requiredDAO;
    
    
    @Autowired
    private HasSuccessFactorKpiDao   successFactorKpiDao;
    
    
    
    @Override
    public void deleteKpi(final Kpi kpi) {
    
    
        final Integer idKpi = kpi.getId();
        
        final MeasureCriteria measureCriteria = new MeasureCriteria();
        measureCriteria.createCriteria().andIdKpiEqualTo(idKpi);
        measureService.deleteByCriteria(measureCriteria);
        
        final KpiAlertTypeCriteria kpiAlertTypeCriteria = new KpiAlertTypeCriteria();
        kpiAlertTypeCriteria.createCriteria().andIdKpiEqualTo(idKpi);
        alertDao.deleteByCriteria(kpiAlertTypeCriteria);
        
        final HasSuccessFactorKpiCriteria hasSuccessFactorKpiCriteria =
                new HasSuccessFactorKpiCriteria();
        hasSuccessFactorKpiCriteria.createCriteria().andIdKpiEqualTo(idKpi);
        successFactorKpiDao.deleteByCriteria(hasSuccessFactorKpiCriteria);
        
        delete(kpi);
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.service.kpi.IKPIService#findKPI(org.komea.product.service.dto.KpiKey)
     */
    @Override
    public Kpi findKPI(final KpiKey _kpiKey) {
    
    
        return new FindKpi(_kpiKey, requiredDAO).find();
    }
    
    
    /**
     * Method findKPIOrFail.
     * 
     * @param _kpiKey
     *            KpiKey
     * @return Kpi
     * @see org.komea.product.backend.service.kpi.IKPIService#findKPIOrFail(KpiKey)
     */
    @Override
    public Kpi findKPIOrFail(final KpiKey _kpiKey) {
    
    
        return new FindKpiOrFail(_kpiKey, requiredDAO).find();
    }
    
    
    /**
     * Method getCronRegistry.
     * 
     * @return ICronRegistryService
     */
    public ICronRegistryService getCronRegistry() {
    
    
        return cronRegistry;
    }
    
    
    /**
     * Method getEntityService.
     * 
     * @return IEntityService
     */
    public IEntityService getEntityService() {
    
    
        return entityService;
    }
    
    
    /**
     * @return the esperEngine
     */
    public final IEventEngineService getEsperEngine() {
    
    
        return esperEngine;
    }
    
    
    /**
     * Method getKpiDAO.
     * 
     * @return KpiDao
     */
    public KpiDao getKpiDAO() {
    
    
        return requiredDAO;
    }
    
    
    public IKpiQueryRegisterService getKpiQueryRegistry() {
    
    
        return kpiQueryRegistry;
    }
    
    
    /**
     * Method getKpis.
     * 
     * @param entityType
     *            EntityType
     * @param kpiKeys
     *            List<String>
     * @return List<Kpi>
     */
    @Override
    public List<Kpi> getKpis(final EntityType entityType, final List<String> kpiKeys) {
    
    
        if (kpiKeys == null || kpiKeys.isEmpty()) {
            final KpiCriteria kpiCriteria = new KpiCriteria();
            kpiCriteria.createCriteria().andEntityTypeEqualTo(entityType);
            return selectByCriteria(kpiCriteria);
        }
        return selectByKeys(kpiKeys);
        
    }
    
    
    /**
     * Retuens the last measure of a kpi
     * 
     * @param _measureKey
     *            the kpi key
     * @param findKPIOrFail
     *            the kpi
     * @param entity
     *            the entity.
     * @return the measure
     */
    public Measure getLastMeasureOfKpi(final Kpi findKPIOrFail, final IEntity entity) {
    
    
        LOGGER.debug("Fetching last measures for KPI {} and entity {}", findKPIOrFail.getKpiKey(),
                entity);
        final MeasureCriteria criteria = new MeasureCriteria();
        final HistoryKey hKey = HistoryKey.of(findKPIOrFail, entity);
        final Measure valueMeasure =
                CollectionUtil.singleOrNull(measureService.getFilteredHistory(hKey, 1, criteria));
        LOGGER.debug("Returning value {}", valueMeasure);
        return valueMeasure;
    }
    
    
    /**
     * @return the measureService
     */
    public final IHistoryService getMeasureService() {
    
    
        return measureService;
    }
    
    
    /**
     * Project : DAO
     * 
     * @return the project DAO.
     */
    public ProjectDao getProjectDao() {
    
    
        return projectDao;
    }
    
    
    @Override
    public Measure getRealTimeMeasure(final KpiKey _key) {
    
    
        LOGGER.debug("Obtain the real time measure for -> {}", _key);
        final Kpi kpiOrFail = findKPIOrFail(_key);
        final ICEPQuery queryOrFail = esperEngine.getQueryOrFail(kpiOrFail.computeKPIEsperKey());
        final Measure measureKey =
                Measure.initializeMeasureFromKPIKey(kpiOrFail.getId(), _key.getEntityKey());
        //
        final List<IEntity> entitiesAssociatedToKpiKey = getEntitiesAssociatedToKpiKey(_key);
        if (entitiesAssociatedToKpiKey.isEmpty()) { throw new EntityNotFoundException(
                _key.getEntityKey()); }
        if (entitiesAssociatedToKpiKey.size() > 1) { throw new IllegalArgumentException(
                "Cannot return a measure, many entities are referenced by the KpiKey " + _key); }
        //
        final IEntity entity = CollectionUtil.singleOrNull(entitiesAssociatedToKpiKey);
        measureKey.setEntity(entity.entityType(), entity.getId());
        final ITupleResultMap<Number> map = queryOrFail.getResult().asMap();
        final Number number = map.get(entity.getEntityKey());
        if (number != null) {
            measureKey.setValue(number.doubleValue());
        }
        LOGGER.debug("Obtain the real time measure : {} result = {}", _key, measureKey.getValue());
        return measureKey;
    }
    
    
    @Override
    public List<Measure> getRealTimeMeasuresFromEntities(
            final List<Kpi> kpis,
            final List<BaseEntityDto> entities) {
    
    
        final List<Measure> measures = new ArrayList<Measure>(kpis.size() * entities.size());
        for (final BaseEntityDto entity : entities) {
            for (final Kpi kpi : kpis) {
                try {
                    final Measure measure = getRealTimeMeasure(KpiKey.ofKpiAndEntity(kpi, entity));
                    if (measure != null && measure.getValue() != null) {
                        measures.add(measure);
                    }
                } catch (final Exception ex) {
                    LOGGER.error(
                            "Error with getRealTimeMeasure(kpiKey) where kpiKey="
                                    + KpiKey.ofKpiAndEntity(kpi, entity), ex);
                }
            }
        }
        return measures;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.genericservice.AbstractService#getRequiredDAO()
     */
    @Override
    public IGenericDAO<Kpi, Integer, KpiCriteria> getRequiredDAO() {
    
    
        return requiredDAO;
    }
    
    
    /**
     * Method getKpiSingleValue.
     * 
     * @param _kpiKey
     *            KpiKey
     * @return Number
     * @see org.komea.product.backend.service.kpi.IKPIService#getSingleValue(KpiKey)
     */
    @Override
    public Number getSingleValue(final KpiKey _kpiKey) {
    
    
        final Kpi kpiOrFail = findKPIOrFail(_kpiKey);
        final ICEPResult queryResult = kpiQueryRegistry.getQueryValueFromKpi(kpiOrFail);
        
        return queryResult.asNumber().doubleValue();
    }
    
    
    /**
     * Method saveOrUpdateKpi.
     * 
     * @param _kpi
     *            Kpi
     * @see org.komea.product.backend.service.kpi.IKPIService#saveOrUpdate(Kpi)
     */
    
    @Override
    public void saveOrUpdate(final Kpi _kpi) {
    
    
        if (_kpi.getId() == null) {
            LOGGER.debug("Saving new KPI : {}", _kpi.getKpiKey());
            if (findKPI(KpiKey.ofKpi(_kpi)) != null) { throw new KpiAlreadyExistingException(
                    _kpi.getKpiKey()); }
            requiredDAO.insert(_kpi);
        } else {
            LOGGER.debug("KPI {} updated", _kpi.getKpiKey());
            updateByPrimaryKeyWithBlobs(_kpi);
        }
        
        kpiQueryRegistry.registerOrUpdateQueryFromKpi(_kpi);
    }
    
    
    @Override
    public void saveOrUpdateKpi(
            final Kpi kpi,
            final List<KpiAlertType> alertTypes,
            final List<SuccessFactor> successFactors) {
    
    
        saveOrUpdate(kpi);
        final Integer idKpi = kpi.getId();
        
        final KpiAlertTypeCriteria kpiAlertTypeCriteria = new KpiAlertTypeCriteria();
        kpiAlertTypeCriteria.createCriteria().andIdKpiEqualTo(idKpi);
        alertDao.deleteByCriteria(kpiAlertTypeCriteria);
        if (alertTypes != null) {
            for (final KpiAlertType alertType : alertTypes) {
                alertDao.insert(alertType);
            }
        }
        
        final HasSuccessFactorKpiCriteria hasSuccessFactorKpiCriteria =
                new HasSuccessFactorKpiCriteria();
        hasSuccessFactorKpiCriteria.createCriteria().andIdKpiEqualTo(idKpi);
        successFactorKpiDao.deleteByCriteria(hasSuccessFactorKpiCriteria);
        if (successFactors != null) {
            for (final SuccessFactor successFactor : successFactors) {
                successFactorKpiDao
                        .insert(new HasSuccessFactorKpiKey(successFactor.getId(), idKpi));
            }
        }
    }
    
    
    @Override
    public List<Kpi> selectAll() {
    
    
        return requiredDAO.selectByCriteriaWithBLOBs(null);
    }
    
    
    /**
     * Method setCronRegistry.
     * 
     * @param _cronRegistry
     *            ICronRegistryService
     */
    public void setCronRegistry(final ICronRegistryService _cronRegistry) {
    
    
        cronRegistry = _cronRegistry;
    }
    
    
    /**
     * Method setEntityService.
     * 
     * @param _entityService
     *            IEntityService
     */
    public void setEntityService(final IEntityService _entityService) {
    
    
        entityService = _entityService;
    }
    
    
    /**
     * @param _esperEngine
     *            the esperEngine to set
     */
    public final void setEsperEngine(final IEventEngineService _esperEngine) {
    
    
        esperEngine = _esperEngine;
    }
    
    
    /**
     * Method setKpiDAO.
     * 
     * @param _kpiDAO
     *            KpiDao
     */
    public void setKpiDAO(final KpiDao _kpiDAO) {
    
    
        requiredDAO = _kpiDAO;
    }
    
    
    public void setKpiQueryRegistry(final IKpiQueryRegisterService _kpiQueryRegistry) {
    
    
        kpiQueryRegistry = _kpiQueryRegistry;
    }
    
    
    /**
     * @param _measureService
     *            the measureService to set
     */
    public final void setMeasureService(final IMeasureHistoryService _measureService) {
    
    
        measureService = _measureService;
    }
    
    
    public void setProjectDao(final ProjectDao _projectDao) {
    
    
        projectDao = _projectDao;
    }
    
    
    /**
     * @param _requiredDAO
     */
    public void setRequiredDAO(final KpiDao _requiredDAO) {
    
    
        requiredDAO = _requiredDAO;
    }
    
    
    /**
     * Stores the measure of a kpi in the database
     * 
     * @param _kpiKey
     *            the kpi key (with reference to the entity)
     * @param _kpiValue
     *            the value.
     */
    @Override
    public void storeMeasureOfAKpiInDatabase(final KpiKey _kpiKey, final Number _kpiValue) {
    
    
        final Kpi findKPI = findKPIOrFail(_kpiKey);
        final Measure measure =
                Measure.initializeMeasureFromKPIKey(findKPI.getId(), _kpiKey.getEntityKey());
        
        measure.setValue(_kpiValue.doubleValue());
        measureService.storeMeasure(measure);
        final int purgeHistory = measureService.buildHistoryPurgeAction(findKPI).purgeHistory();
        LOGGER.debug("Purge history : {} items", purgeHistory);
    }
    
    
    /**
     * Method storeValueInHistory.
     * 
     * @param _kpiKey
     *            KpiKey
     * @throws KPINotFoundException
     * @see org.komea.product.backend.service.kpi.IKPIService#storeValueInHistory(KpiKey)
     */
    @Transactional
    @Override
    public void storeValueInHistory(final KpiKey _kpiKey) throws KPINotFoundException {
    
    
        final Kpi kpi = findKPIOrFail(_kpiKey);
        final ICEPResult queryResult = kpiQueryRegistry.getQueryValueFromKpi(kpi);
        
        if (kpi.isGlobal()) {
            final Number singleResult = queryResult.asNumber();
            storeMeasureOfAKpiInDatabase(_kpiKey, singleResult.doubleValue());
        } else {
            final Map<EntityKey, Number> simplifiedMap =
                    (Map) queryResult.asMap().asSimplifiedMap();
            for (final java.util.Map.Entry<EntityKey, Number> kpiLineValue : simplifiedMap
                    .entrySet()) {
                final KpiKey kpiKeyWithEntity =
                        KpiKey.ofKpiNameAndEntityKey(_kpiKey.getKpiName(), kpiLineValue.getKey());
                storeMeasureOfAKpiInDatabase(kpiKeyWithEntity, kpiLineValue.getValue());
                
            }
        }
        
    }
    
    
    /**
     * Returns the list of entities associated to a KPI key.
     * 
     * @param _kpiKey
     *            the measure
     * @return the list of entities.
     */
    private List<IEntity> getEntitiesAssociatedToKpiKey(final KpiKey _kpiKey) {
    
    
        final Kpi findKPIOrFail = findKPIOrFail(_kpiKey);
        List<IEntity> entities = null;
        if (_kpiKey.isAssociatedToEntity()) {
            final IEntity entityAssociatedToKpi = entityService.getEntityAssociatedToKpi(_kpiKey);
            if (entityAssociatedToKpi == null) { throw new EntityNotFoundException(
                    _kpiKey.getEntityKey()); }
            entities = Collections.singletonList(entityAssociatedToKpi);
        } else {
            
            entities = entityService.loadEntities(findKPIOrFail.getEntityType());
            
        }
        LOGGER.debug("Entities associated to KPI key {}: {}", _kpiKey, entities.size());
        return entities;
    }
    
    
    private void updateByPrimaryKeyWithBlobs(final Kpi _kpi) {
    
    
        final KpiCriteria kpiCriteria = new KpiCriteria();
        kpiCriteria.createCriteria().andIdEqualTo(_kpi.getId());
        requiredDAO.updateByCriteriaWithBLOBs(_kpi, kpiCriteria);
    }
    
    
    @Override
    protected KpiCriteria createKeyCriteria(final String key) {
    
    
        final KpiCriteria criteria = new KpiCriteria();
        criteria.createCriteria().andKpiKeyEqualTo(key);
        return criteria;
    }
    
}
