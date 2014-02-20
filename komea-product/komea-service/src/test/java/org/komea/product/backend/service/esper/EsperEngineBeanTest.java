/**
 * 
 */

package org.komea.product.backend.service.esper;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.komea.product.backend.api.IEsperEngine;
import org.komea.product.database.alert.IEvent;
import org.mockito.Mockito;

import com.espertech.esper.client.EPStatement;



/**
 * @author sleroy
 * @version $Revision: 1.0 $
 */
public class EsperEngineBeanTest
{
    
    
    private IEsperEngine esperEngine = null;
    
    
    
    /**
    
     * @throws Exception
     * @throws java.lang.Exception */
    @After
    public void closeAfter() throws Exception {
    
    
        ((EsperEngineBean) esperEngine).destroy();
        
    }
    
    
    /**
    
     * @throws Exception
     * @throws java.lang.Exception */
    @Before
    public void setUp() throws Exception {
    
    
        final EsperEngineBean esperEngineBean = new EsperEngineBean();
        esperEngine = esperEngineBean;
        esperEngineBean.init();
        
    }
    
    
    /**
     * Test method for {@link org.komea.product.backend.service.esper.EsperEngineBean#createEPL(java.lang.String, java.lang.String)}.
     */
    @Test
    public final void testCreateEPL() {
    
    
        final EPStatement epl =
                esperEngine.createEPL(new QueryDefinition("select * from Event", "demo"));
        Assert.assertNotNull(epl);
        Assert.assertTrue(esperEngine.existEPL("demo"));
    }
    
    
    /**
     * Test method for {@link org.komea.product.backend.service.esper.EsperEngineBean#existEPL(java.lang.String)}.
     */
    @Test
    public final void testExistEPL() {
    
    
        Assert.assertFalse(esperEngine.existEPL("demo"));
        final EPStatement epl =
                esperEngine.createEPL(new QueryDefinition("select * from Event", "demo"));
        Assert.assertNotNull(epl);
        Assert.assertTrue(esperEngine.existEPL("demo"));
    }
    
    
    /**
     * Test method for {@link org.komea.product.backend.service.esper.EsperEngineBean#getEsper()}.
     */
    @Test
    public final void testGetEsper() {
    
    
        Assert.assertNotNull(esperEngine.getEsper());
    }
    
    
    /**
     * Test method for {@link org.komea.product.backend.service.esper.EsperEngineBean#existEPL(java.lang.String)}.
     */
    @Test
    public final void testGetStatementNames() {
    
    
        Assert.assertFalse(esperEngine.existEPL("demo"));
        final EPStatement epl =
                esperEngine.createEPL(new QueryDefinition("select * from Event", "demo"));
        Assert.assertNotNull(epl);
        Assert.assertEquals(2, esperEngine.getStatementNames().length);
    }
    
    
    /**
         * Test method for {@link org.komea.product.backend.service.esper.EsperEngineBean#sendEvent(org.komea.product.database.alert.IEvent)}.
         */
        @Test
        public final void testSendEvent() {
        
        
            esperEngine.sendEvent(Mockito.mock(IEvent.class));
        }
    
}
