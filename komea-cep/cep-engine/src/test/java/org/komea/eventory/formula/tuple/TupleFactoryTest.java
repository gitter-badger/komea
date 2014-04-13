
package org.komea.eventory.formula.tuple;



import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.komea.eventory.api.formula.tuple.ITuple;
import org.komea.eventory.formula.tuple.TupleFactory;



public class TupleFactoryTest
{
    
    
    @Test 
    public final void testNewTupleArrayList() throws Exception {
    
    
        final ITuple newTuple = TupleFactory.newTuple(Collections.singletonList("truc"));
        Assert.assertEquals("truc", newTuple.getFirst());
        Assert.assertTrue(newTuple.isSingleton());
    }
    
    
    @Test 
    public final void testNewTupleObjectObjectArray() throws Exception {
    
    
        final ITuple newTuple = TupleFactory.newTuple("truc");
        Assert.assertEquals("truc", newTuple.getFirst());
        Assert.assertTrue(newTuple.isSingleton());
    }
    
}