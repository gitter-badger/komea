/**
 * 
 */

package org.komea.eventory.query.predefined;



import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.komea.eventory.api.formula.ITupleResultMap;
import org.komea.eventory.api.formula.tuple.IEventGroup;
import org.komea.eventory.api.formula.tuple.IEventTable;
import org.komea.eventory.api.formula.tuple.ITuple;
import org.komea.eventory.filter.Event;
import org.komea.eventory.formula.tuple.EventGroup;
import org.komea.eventory.formula.tuple.TupleFactory;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



/**
 * @author sleroy
 */
public class XPathGroupByFormulaTest
{
    
    
    /**
     * Test method for
     * {@link org.komea.eventory.query.predefined.XPathGroupByFormula#processMap(org.komea.eventory.api.formula.tuple.IEventTable, java.util.Map)}
     * .
     */
    @Test
    public final void testProcessMap() throws Exception {
    
    
        // requires to build an tuple map and provided it as an iterator
        // the formula counts events.
        final XPathGroupByFormula xPathGroupByFormula =
                new XPathGroupByFormula("count(/streams/event)");
        
        final IEventTable eventTable = mock(IEventTable.class);
        final Map<ITuple, IEventGroup> eventGroups = new HashMap<ITuple, IEventGroup>();
        final EventGroup eventGroup = new EventGroup();
        final Event event = new Event();
        event.setMessage("truc");
        eventGroup.addEvent(event);
        eventGroups.put(TupleFactory.newTuple("value"), eventGroup);
        when(eventTable.iterator()).thenReturn(eventGroups.entrySet());
        final ITupleResultMap processMap =
                xPathGroupByFormula.processMap(eventTable, Collections.EMPTY_MAP);
        assertEquals("Value for the tuple is 1", Double.valueOf(1),
                processMap.getValue(TupleFactory.newTuple("value")));
    }
}