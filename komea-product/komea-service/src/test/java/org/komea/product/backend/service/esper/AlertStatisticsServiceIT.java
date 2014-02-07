/**
 * 
 */

package org.komea.product.backend.service.esper;



import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.komea.product.database.alert.Alert;
import org.komea.product.database.alert.AlertBuilder;
import org.komea.product.service.dto.AlertTypeStatistic;
import org.komea.product.test.spring.AbstractSpringIntegrationTestCase;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author sleroy
 */
public class AlertStatisticsServiceIT extends AbstractSpringIntegrationTestCase
{
    
    
    @Autowired
    private AlertStatisticsService alertStats;
    
    @Autowired
    private EsperEngineBean        esperEngine;
    
    
    
    /**
     * Test method for {@link org.komea.product.backend.service.esper.AlertStatisticsService#getReceivedAlertTypesIn24LastHours()}.
     */
    @Test
    @Ignore
    public final void testGetReceivedAlertTypesIn24LastHours() {
    
    
        final Alert alert =
                AlertBuilder.newAlert().type("TYPE1").provided("JENKINS").category("SCM")
                        .build();
        esperEngine.sendAlert(alert);
        esperEngine.sendAlert(alert);
        esperEngine.sendAlert(alert);
        esperEngine.sendAlert(alert);
        
        final List<AlertTypeStatistic> receivedAlertTypesIn24Hours =
                alertStats.getReceivedAlertTypesIn24LastHours();
        final AlertTypeStatistic alertTypeStatistic = receivedAlertTypesIn24Hours.get(0);
        Assert.assertTrue(4L <= alertTypeStatistic.getNumber());
        
        boolean found = false;
        for (final AlertTypeStatistic stat : receivedAlertTypesIn24Hours) {
            found |= stat.getType().equals("TYPE1");
        }
        Assert.assertTrue("Alert is not found", found);
        ;
        
    }
}