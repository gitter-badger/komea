/**
 * 
 */

package org.komea.product.backend.service.demodata;



import javax.annotation.PostConstruct;

import org.komea.product.backend.plugin.api.ProviderPlugin;
import org.komea.product.backend.service.kpi.IKPIService;
import org.komea.product.backend.service.kpi.KpiBuilder;
import org.komea.product.database.enums.EntityType;
import org.komea.product.database.enums.ProviderType;
import org.komea.product.database.model.Kpi;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author sleroy
 */

@ProviderPlugin(
        eventTypes = {},
        icon = "provider",
        name = "KPI Provider plugin",
        type = ProviderType.NEWS,
        url = "/provider")
public class KpiDemoService
{
    
    
    @Autowired
    private IKPIService kpiService;
    
    
    
    /**
     * 
     */
    public KpiDemoService() {
    
    
        super();
        
    }
    
    
    @PostConstruct
    public void initialize() {
    
    
        kpiService.saveOrUpdate(numberSuccessBuildPerWeek());
        kpiService.saveOrUpdate(numberSuccessBuildPerDay());
        kpiService.saveOrUpdate(numberBuildPerDay());
        kpiService.saveOrUpdate(numberBuildPerMonth());
    }
    
    
    // KPI : Durée maximale de bon fonctionnement (tps entre deux builds success average)
    // KPI : Durée de non-fonctionnement (moyenne)
    // KPI : Durée de non-fonctionnement (maximale)
    
    public Kpi numberBuildPerDay() {
    
    
        return KpiBuilder
                .createAscending()
                .nameAndKeyDescription("Number of build per day")
                .entityType(EntityType.PROJECT)
                .expirationMonth()
                .query("SELECT project as entity, COUNT(*) as value FROM Event.win:time(1 day) WHERE eventType.eventKey IN('build_complete', 'build_failed')  GROUP BY project")
                .cronSixHours().build();
        
    }
    
    
    public Kpi numberBuildPerMonth() {
    
    
        return KpiBuilder
                .createAscending()
                .nameAndKeyDescription("Number of build per month")
                .entityType(EntityType.PROJECT)
                .expirationYear()
                .query("SELECT project as entity, COUNT(*) as value FROM Event.win:time(1 month) WHERE eventType.eventKey IN('build_complete', 'build_failed')  GROUP BY project")
                .cronWeek().build();
        
    }
    
    
    public Kpi numberSuccessBuildPerDay() {
    
    
        return KpiBuilder
                .createAscending()
                .nameAndKeyDescription("Number of successful build per day")
                .entityType(EntityType.PROJECT)
                .expirationMonth()
                .query("SELECT project as entity, COUNT(*) as value FROM Event.win:time(1 day) WHERE eventType.eventKey='build_complete' GROUP BY project")
                .cronSixHours().build();
    }
    
    
    public Kpi numberSuccessBuildPerWeek() {
    
    
        return KpiBuilder
                .createAscending()
                .nameAndKeyDescription("Number of successful build per week")
                .entityType(EntityType.PROJECT)
                .expirationYear()
                .query("SELECT project as entity, COUNT(*) as value FROM Event.win:time(1 week) WHERE eventType.eventKey='build_complete' GROUP BY project")
                .cronThreeDays().build();
    }
}
