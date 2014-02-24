
package org.komea.product.backend.service.kpi;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.komea.event.factory.JenkinsEventFactory;
import org.komea.product.backend.api.IEsperEngine;
import org.komea.product.backend.esper.test.EsperQueryTester;
import org.komea.product.backend.service.esper.IEventPushService;
import org.komea.product.backend.service.esper.IEventStatisticsService;
import org.komea.product.backend.service.esper.IEventViewerService;
import org.komea.product.backend.service.esper.QueryDefinition;
import org.komea.product.database.alert.IEvent;
import org.komea.product.service.dto.EventTypeStatistic;
import org.komea.product.test.spring.AbstractSpringIntegrationTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



/**
 */
public class KPIServiceIT extends AbstractSpringIntegrationTestCase
{
    
    
    private static final String     TEST_QUERY = "testQuery";
    
    @Autowired
    private IKPIService             kpiService;
    
    @Autowired
    private IEventPushService       eventPushService;
    
    @Autowired
    private IEventStatisticsService systemProject;
    
    @Autowired
    private IEsperEngine            esperEngine;
    
    private static Logger           LOGGER     = LoggerFactory.getLogger(KPIServiceIT.class);
    
    @Autowired
    private IEventViewerService     viewerService;
    
    
    
    public KPIServiceIT() {
    
    
        super();
    }
    
    
    @Test
    public void testifAlertStatisticsKPIAreWorking() {
    
    
        esperEngine.createEPL(new QueryDefinition("SELECT * FROM Event", TEST_QUERY));
        
        
        final IEvent eventToSend =
                EsperQueryTester.convertToEventDTO(new JenkinsEventFactory().sendBuildComplete(
                        "SCERTIFY", 12, "TRUC"));
        for (int i = 0; i < 10; ++i) {
            
            eventPushService.sendEvent(eventToSend);
        }
        System.out.println(kpiService.listAllKpis());
        final long numberAlerts = systemProject.getReceivedAlertsIn24LastHours();
        LOGGER.info("Received alerts {}", numberAlerts);
        Assert.assertTrue(numberAlerts >= 10);
        final List<EventTypeStatistic> receivedAlertTypesIn24LastHours =
                systemProject.getReceivedAlertTypesIn24LastHours();
        LOGGER.info("Received alerts {}", receivedAlertTypesIn24LastHours);
        // On récupère la liste des alertes reçues dans ce laps de temps, pour vérifier que Esper a bien reçu nos alertes
        final List<IEvent> instantView = viewerService.getInstantView(TEST_QUERY);
        boolean found = false;
        for (final IEvent event : instantView) {
            found |=
                    eventToSend.getEventType().getEventKey()
                            .equals(event.getEventType().getEventKey());
        }
        Assert.assertTrue("We received alerts from the corresponding type", found);
        found = false;
        for (final EventTypeStatistic stat : receivedAlertTypesIn24LastHours) {
            found |= eventToSend.getEventType().getEventKey().equals(stat.getType());
        }
        Assert.assertTrue("Event is not found", found);
        
    }
    
}
