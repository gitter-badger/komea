/**
 * 
 */

package org.komea.product.backend.service.kpi;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.komea.product.backend.api.IEventEngineService;
import org.komea.product.backend.service.cron.ICronRegistryService;
import org.komea.product.backend.service.entities.IEntityService;
import org.komea.product.database.dao.KpiDao;
import org.komea.product.database.dao.ProjectDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;



/**
 * @author sleroy
 */
@RunWith(MockitoJUnitRunner.class)
public class KpiQueryRegisterServiceTest
{
    
    
    @Mock
    private ICronRegistryService    cronRegistry;
    
    
    @Mock
    private IEntityService          entityService;
    
    
    @Mock
    private IEventEngineService     esperEngine;
    
    
    @InjectMocks
    private KpiQueryRegisterService kpiQueryRegisterService;
    
    
    @Mock
    private ProjectDao              projectDao;
    @Mock
    private KpiDao                  requiredDAO;
    
    
    
    /**
     * Test method for
     * {@link org.komea.product.cep.tester.KpiQueryRegisterService#createOrUpdateQueryFromKpi(org.komea.product.database.model.Kpi)} .
     */
    @Test
    public final void testCreateOrUpdateQueryFromKpi() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
    
    /**
     * Test method for
     * {@link org.komea.product.cep.tester.KpiQueryRegisterService#evaluateFormulaAndRegisterQuery(org.komea.product.database.model.Kpi)}.
     */
    @Test
    public final void testEvaluateFormulaAndRegisterQuery() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
    
    /**
     * Test method for
     * {@link org.komea.product.cep.tester.KpiQueryRegisterService#getQueryValueFromKpi(org.komea.product.database.model.Kpi)}.
     */
    @Test
    public final void testGetQueryValueFromKpi() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
}
