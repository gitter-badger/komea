
package org.komea.product.rest.client;



import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.komea.product.database.api.IEntity;
import org.komea.product.rest.client.api.IMeasuresAPI;
import org.komea.product.service.dto.KPIValueTable;
import org.komea.product.service.dto.KpiKey;



public class MeasuresAPIIT
{
    
    
    /**
     * 
     */
    @Rule
    public ServerMethodRule serverInit = new ServerMethodRule();
    
    
    
    @Test()
    public void testLastListMeasure() throws Exception {
    
    
        final IMeasuresAPI measuresAPI =
                RestClientFactory.INSTANCE.createMeasuresAPI("http://localhost:"
                        + serverInit.getPort() + "/komea");
        Assert.assertNotNull(measuresAPI);
        final KpiKey kpiKey = KpiKey.ofKpiName("NUMBER_OF_BUILD_PER_DAY");
        final double val = measuresAPI.lastMeasuresForKpiKey(kpiKey);
        // Assert.assertTrue(projects.get(0) instanceof PersonGroup);
        Assert.assertEquals(0, val, 0.1);
    }
    
    
    @Test
    public void testRealtimeMeasure() throws Exception {
    
    
        final IMeasuresAPI measuresAPI =
                RestClientFactory.INSTANCE.createMeasuresAPI("http://localhost:"
                        + serverInit.getPort() + "/komea");
        Assert.assertNotNull(measuresAPI);
        final KpiKey kpiKey = KpiKey.ofKpiName("NUMBER_OF_BUILD_PER_DAY");
        final KPIValueTable<IEntity> timeValues = measuresAPI.getKpiRealTimeValues(kpiKey);
        Assert.assertNotNull(timeValues);
        Assert.assertEquals("NUMBER_OF_BUILD_PER_DAY", timeValues.getKpi().getKpiKey());
        // Assert.assertTrue(projects.get(0) instanceof PersonGroup);
        // Assert.assertFalse(projects.isEmpty());
    }
    
}
