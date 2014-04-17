/**
 * 
 */

package org.komea.product.backend.service.kpi;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.komea.product.database.dao.MeasureDao;
import org.komea.product.database.model.Kpi;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;



/**
 * @author sleroy
 */
@RunWith(MockitoJUnitRunner.class)
public class HistoryPurgePerDaysActionTest
{
    
    
    @InjectMocks
    private HistoryPurgePerDaysAction historyPurgePerDaysAction;
    
    
    @Mock
    private Kpi                       kpi;
    @Mock
    private MeasureDao                measureDAO;
    
    
    
    /**
     * Test method for {@link org.komea.product.cep.tester.HistoryPurgePerDaysAction#purgeHistory()}.
     */
    @Test
    public final void testPurgeHistory() throws Exception {
    
    
        // TODO
        org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
}
