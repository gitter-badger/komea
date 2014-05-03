
package org.komea.product.plugins.kpi.standard.jenkins;



import org.junit.Test;
import org.komea.event.factory.JenkinsEventsFactory;
import org.komea.product.cep.tester.CEPQueryTester;
import org.komea.product.plugins.kpi.standard.jenkins.NumberOfFixedBuildPerUserPerDay;



public class NumberOfFixedBuildPerUserPerDayTest
{
    
    
    @Test 
    public final void NumberOfFixedBuildPerUserTest() throws Exception {
    
    
        final NumberOfFixedBuildPerUserPerDay buildPerDay = new NumberOfFixedBuildPerUserPerDay();
        
        final CEPQueryTester newTest = CEPQueryTester.newTest();
        
        final CEPQueryTester withQuery = newTest.withQuery(buildPerDay);
        
        withQuery.sendEvent(JenkinsEventsFactory.sendBuildStarted("SCERTIFY", 1, "TRUC", "sleroy"));
        withQuery.sendEvent(JenkinsEventsFactory.sendBuildComplete("KOMEA", 1, "TRUC", "yoip"));
        withQuery.sendEvent(JenkinsEventsFactory.sendBuildFixed("SCERTIFY", 1, "TRUC", "sleroy"));
        withQuery.sendEvent(JenkinsEventsFactory.sendBuildBroken("ALBRAND", 1, "TRUC", "sleroy"));
        withQuery.sendEvent(JenkinsEventsFactory.sendBuildStarted("KOMEA", 1, "TRUC", "yoip"));
        withQuery.sendEvent(JenkinsEventsFactory.sendBuildStarted("KOMEA", 1, "TRUC", "yoip"));
        withQuery.sendEvent(JenkinsEventsFactory.sendBuildBroken("KOMEA", 1, "TRUC", "yoip"));
        newTest.dump().hasResults(new Object[][]
            {
                { newTest.getMockPerson().get("sleroy").getEntityKey(), 1 } }
        
        ).runTest();
    }
    
}