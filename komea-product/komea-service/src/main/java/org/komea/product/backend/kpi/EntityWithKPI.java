
package org.komea.product.backend.kpi;



import java.util.ArrayList;
import java.util.List;

import org.komea.product.backend.service.business.IEntityWithKPIFacade;
import org.komea.product.database.api.IEntity;
import org.komea.product.database.model.Kpi;



/**
 * Builds a EntityWithKPI with KPI.
 * 
 * @author sleroy
 * @param <TEntity>
 */
public class EntityWithKPI<TEntity extends IEntity> implements IEntityWithKPIFacade<TEntity>
{
    
    
    private final TEntity entity;
    
    private List<Kpi>     kpis = new ArrayList<Kpi>();
    
    
    
    /**
     * Builds an entity wrapper.
     * 
     * @param _entity
     * @param _kpis
     * @param _entityType
     */
    public EntityWithKPI(final TEntity _entity, final List<Kpi> _kpis) {
    
    
        super();
        
        entity = _entity;
        kpis = _kpis;
    }
    
    
    @Override
    public TEntity getEntity() {
    
    
        return entity;
    }
    
    
    @Override
    public Kpi getKpi(final String _kpiName) {
    
    
        for (final Kpi kpi : kpis) {
            if (_kpiName.equals(kpi.getKpiKey())) { return kpi; }
        }
        
        return null;
    }
    
    
    @Override
    public List<Kpi> getListofKpis() {
    
    
        return kpis;
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    
    
        return "EntityWithKPI [entity=" + entity + ", kpis=" + kpis + "]";
    }
    
    
}