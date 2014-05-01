/**
 * 
 */

package org.komea.eventory.formula.tuple;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.komea.eventory.api.engine.ICEPStatement;
import org.komea.eventory.api.formula.ICEPFormula;
import org.komea.eventory.api.formula.ITupleResultMap;
import org.komea.eventory.api.formula.tuple.IEventTable;
import org.komea.eventory.api.formula.tuple.IEventTableGenerator;
import org.komea.eventory.api.formula.tuple.ITupleCreator;
import org.komea.eventory.api.formula.tuple.ITuplerFormula;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * This class defines a formula with tuple
 * 
 * @author sleroy
 */
@SuppressWarnings("rawtypes")
public class GroupByFormula implements ICEPFormula<Serializable, ITupleResultMap>
{
    
    
    private static final Logger     LOGGER = LoggerFactory.getLogger("tupler-formula");
    
    
    private final ITuplerFormula<?> formulaTupler;
    
    
    private final ITupleCreator     tupleCreator;
    
    
    
    /**
     * @param _parameters
     */
    public GroupByFormula(final ITupleCreator _tupleCreator, final ITuplerFormula _formulaTupler) {
    
    
        super();
        tupleCreator = _tupleCreator;
        formulaTupler = _formulaTupler;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPFormula#compute(org.komea.eventory.api.ICEPStatement, java.util.Map)
     */
    @Override
    public ITupleResultMap compute(
            final ICEPStatement<Serializable> _statement,
            final Map<String, Object> _parameters) {
    
    
        LOGGER.debug("preparing events to grouping...");
        final IEventTableGenerator eventTupler = new EventTableGenerator(tupleCreator);
        final List<Serializable> defaultStorage = _statement.getDefaultStorage();
        LOGGER.debug("grouping {} events", defaultStorage.size());
        final IEventTable tupleMap = eventTupler.generateTable(defaultStorage);
        LOGGER.debug("tuple map produced {}", tupleMap);
        final ITupleResultMap<?> resultMap = formulaTupler.processMap(tupleMap, _parameters);
        LOGGER.debug("resultMap produced {}", resultMap);
        
        return resultMap;
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    
    
        return "GroupByFormula [formulaTupler="
                + formulaTupler + ", tupleCreator=" + tupleCreator + "]";
    }
    
    
}
