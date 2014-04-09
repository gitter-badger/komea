
package org.komea.product.plugins.kpi.standard;



import org.junit.Test;
import org.komea.event.factory.JenkinsEventsFactory;
import org.komea.product.backend.esper.test.CEPQueryTester;



public class BuildPerDayTest
{
    
    
    @Test
    public final void testBuildPerDay() throws Exception {
    
    
        final BuildPerDay buildPerDay = new BuildPerDay();
        final CEPQueryTester newTest = CEPQueryTester.newTest();
        
        newTest.withQuery(buildPerDay).sendEvent(
                JenkinsEventsFactory.sendBuildStarted("SCERTIFY", 1, "TRUC"));
        newTest.withQuery(buildPerDay).sendEvent(
                JenkinsEventsFactory.sendBuildStarted("KOMEA", 1, "TRUC"));
        newTest.withQuery(buildPerDay).sendEvent(
                JenkinsEventsFactory.sendBuildStarted("ALBRAND", 1, "TRUC"));
        newTest.withQuery(buildPerDay).sendEvent(
                JenkinsEventsFactory.sendBuildStarted("KOMEA", 1, "TRUC"));
        newTest.dump().hasResults(new Object[][]
            {
                { newTest.getMockProject().get("SCERTIFY").getEntityKey(), 1 },
                { newTest.getMockProject().get("KOMEA").getEntityKey(), 2 },
                { newTest.getMockProject().get("ALBRAND").getEntityKey(), 1 } }
        
        ).runTest();
        
        
    }
}
