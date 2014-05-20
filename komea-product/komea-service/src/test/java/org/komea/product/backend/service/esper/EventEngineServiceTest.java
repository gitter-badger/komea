/**
 * 
 */

package org.komea.product.backend.service.esper;



import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.komea.eventory.api.bridge.IEventBridgeFactory;
import org.komea.eventory.api.cache.ICacheStorageFactory;
import org.komea.product.backend.service.fs.IKomeaFS;
import org.komea.product.cep.tester.CEPQueryTester;
import org.komea.product.database.alert.IEvent;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



/**
 * @author sleroy
 */
@RunWith(MockitoJUnitRunner.class)
public class EventEngineServiceTest
{
    
    
    private final ICacheStorageFactory cacheStorageFactory = CEPQueryTester.DEFAULT_CACHE_FACTORY;
    
    
    private final IEventBridgeFactory  eventBridgeFactory  = CEPQueryTester.DEFAULT_BRIDGE_FACTORY;
    
    
    @InjectMocks
    private EventEngineService         eventEngineService;
    @Mock
    private IKomeaFS                   komeaFS;
    
    
    
    @After
    public void after() {
    
    
        eventEngineService.destroy();
        
    }
    
    
    @Before
    public void before() {
    
    
        when(komeaFS.getFileSystemFolder(Mockito.anyString())).thenReturn(new File("target"));
        eventEngineService.setCacheStorageFactory(cacheStorageFactory);
        eventEngineService.setEventBridgeFactory(eventBridgeFactory);
        
        
        eventEngineService.init();
        
    }
    
    
    /**
     * Test method for
     * {@link org.komea.product.backend.service.esper.EventEngineService#createOrUpdateQuery(org.komea.product.backend.api.IQueryDefinition)}
     * .
     */
    @Test
    public final void testCreateOrUpdateQuery() throws Exception {
    
    
        final QueryInformations queryInformations =
                new QueryInformations("query", new CEPQueryImplementationStub());
        // WHEN I CONTROL A QUERY THT NOT EXISTS
        // THEN IT RETURNS FALSE AND NULL
        assertNull(eventEngineService.getQuery("query"));
        assertFalse(eventEngineService.existQuery("query"));
        // AFTER I CREATE IT
        eventEngineService.createOrUpdateQuery(queryInformations);
        // IT RETURNS TRUE
        assertTrue(eventEngineService.existQuery("query"));
        // IF I UPDATE AGAIN
        eventEngineService.createOrUpdateQuery(queryInformations);
        // NO ERROR? STILL EXISTS
        assertTrue(eventEngineService.existQuery("query"));
        // I FOUND IT IN THE LiST.
        assertTrue(Lists.newArrayList(eventEngineService.getQueryNames()).contains("query"));
        assertNotNull(eventEngineService.getQuery("query"));
        // I OBTAIN IT ANOTHER WAY
        assertNotNull(eventEngineService.getQueryOrFail("query"));
    }
    
    
    /**
     * Test method for
     * {@link org.komea.product.backend.service.esper.EventEngineService#createQuery(org.komea.product.backend.api.IQueryDefinition)}.
     */
    @Test
    public final void testCreateQuery() throws Exception {
    
    
        testCreateOrUpdateQuery();
    }
    
    
    /**
     * Test method for {@link org.komea.product.backend.service.esper.EventEngineService#sendEvent(org.komea.product.database.alert.IEvent)}
     * .
     */
    @Test
    public final void testSendEvent() throws Exception {
    
    
        eventEngineService.sendEvent(mock(IEvent.class));
    }
    
}
