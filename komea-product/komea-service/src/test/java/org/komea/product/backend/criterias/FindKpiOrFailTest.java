/**
 * 
 */

package org.komea.product.backend.criterias;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.komea.product.database.dao.KpiDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;



/**
 * @author sleroy
 */
@RunWith(MockitoJUnitRunner.class)
public class FindKpiOrFailTest
{
    
    
    @InjectMocks
    private FindKpiOrFail findKpiOrFail;
    
    
    @Mock
    private KpiDao        kpiDao;
    
    
    
    /**
     * Test method for {@link org.komea.product.backend.criterias.FindKpiOrFail#find()}.
     */
    @Test
    public final void testFind() throws Exception {
    
    
        // TODO
        
        org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
}