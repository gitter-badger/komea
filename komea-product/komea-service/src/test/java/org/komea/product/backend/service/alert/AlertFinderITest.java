
package org.komea.product.backend.service.alert;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.komea.product.database.dto.KpiAlertDto;
import org.komea.product.database.dto.SearchKpiAlertsDto;
import org.komea.product.database.enums.ExtendedEntityType;
import org.komea.product.database.enums.Severity;
import org.komea.product.test.spring.AbstractSpringDBunitIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

public class AlertFinderITest extends AbstractSpringDBunitIntegrationTest {
    
    @Autowired
    private IAlertFinderService finderService;
    
    @Before
    public void setUp() throws Exception {
    
    }
    //
    
    @Test
    public final void testFindAlerts() throws Exception {
    
        SearchKpiAlertsDto searchAlert = new SearchKpiAlertsDto();
        searchAlert.addAlertKey("COVERAGE_BRANCH_TOO_LOW");
        searchAlert.addEntityKey("KOMEA");
        searchAlert.setActivatedOnly(true);
        searchAlert.setExtendedEntityType(ExtendedEntityType.PROJECT);
        searchAlert.setSeverityMin(Severity.MAJOR);
        List<KpiAlertDto> alerts = finderService.findAlerts(searchAlert);
        
        Assert.assertTrue(alerts.isEmpty());
    }
}