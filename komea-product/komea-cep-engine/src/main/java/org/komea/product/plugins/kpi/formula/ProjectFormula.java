/**
 * 
 */

package org.komea.product.plugins.kpi.formula;



import java.util.Map;
import java.util.Map.Entry;

import org.komea.eventory.api.engine.ICEPStatement;
import org.komea.eventory.api.formula.ICEPFormula;
import org.komea.product.cep.api.formula.IEventGroup;
import org.komea.product.cep.api.formula.IEventGroupFormula;
import org.komea.product.cep.formula.EventTable;
import org.komea.product.database.alert.IEvent;
import org.komea.product.database.dto.KpiResult;
import org.komea.product.plugins.kpi.tuplecreator.ProjectTupleCreator;
import org.komea.product.service.dto.EntityKey;



/**
 * @author sleroy
 */
public class ProjectFormula implements ICEPFormula<IEvent, KpiResult>
{
    
    
    private final IEventGroupFormula eventValueFormula;
    
    
    
    /**
     * @param _eventValueFormula
     */
    public ProjectFormula(final IEventGroupFormula _eventValueFormula) {
    
    
        eventValueFormula = _eventValueFormula;
        
        
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.cep.api.formula.ICEPFormula#compute(org.komea.eventory.api.engine.ICEPStatement, java.util.Map)
     */
    @Override
    public KpiResult compute(final ICEPStatement<IEvent> _arg0, final Map<String, Object> _arg1) {
    
    
        final EventTable<EntityKey, IEvent> eventTable =
                new EventTable<EntityKey, IEvent>(new ProjectTupleCreator());
        eventTable.fill(_arg0.getAggregateView());
        
        
        final KpiResult kpiResult = new KpiResult();
        for (final Entry<EntityKey, IEventGroup<IEvent>> eventGroupEntry : eventTable.iterator()) {
            if (isInvalidEntity(eventGroupEntry)) {
                continue;
            }
            kpiResult.put(eventGroupEntry.getKey(),
                    eventValueFormula.evaluate(eventGroupEntry.getValue()));
        }
        return kpiResult;
    }


    private boolean isInvalidEntity(final Entry<EntityKey, IEventGroup<IEvent>> eventGroupEntry) {
    
    
        return eventGroupEntry.getKey().isUncompleteKey()
                || !eventGroupEntry.getKey().isProjectKey();
    }
}