/**
 * 
 */

package org.komea.product.backend.service.olap;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.junit.Test;
import org.komea.product.database.model.Measure;

import com.google.common.collect.Lists;

/**
 * @author sleroy
 */
public class KpiMathServiceTest {
    
    /**
     * Test method for {@link org.komea.product.backend.service.olap.KpiMathService#computeAverageFromMeasures(java.util.List)}.
     */
    @Test
    public final void testComputeAverageFromMeasures() throws Exception {
    
        final KpiMathService kpiMathService = new KpiMathService();
        final Measure fakeMeasure = fakeMeasure(12);
        final Measure fakeMeasure2 = fakeMeasure(24);
        final ArrayList<Measure> arrayList = Lists.newArrayList(fakeMeasure, fakeMeasure2);
        final double measures = kpiMathService.computeAverageFromMeasures(arrayList);
        final Mean mean = new Mean();
        
        assertEquals(measures, mean.evaluate(new double[] {
                12, 24 }), 0.0d);
    }
    
    /**
     * Test method for {@link org.komea.product.backend.service.olap.KpiMathService#computeSumFromMeasures(java.util.List)}.
     */
    @Test
    public final void testComputeSumFromMeasures() throws Exception {
    
        final KpiMathService kpiMathService = new KpiMathService();
        final Measure fakeMeasure = fakeMeasure(12);
        final Measure fakeMeasure2 = fakeMeasure(24);
        final ArrayList<Measure> arrayList = Lists.newArrayList(fakeMeasure, fakeMeasure2);
        final double measures = kpiMathService.computeSumFromMeasures(arrayList);
        final Sum mean = new Sum();
        
        assertEquals(measures, mean.evaluate(new double[] {
                12, 24 }), 0.0d);
    }
    
    private Measure fakeMeasure(final double _value) {
    
        final Measure measure = new Measure();
        measure.setValue(_value);
        return measure;
        
    }
    
}