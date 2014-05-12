/**
 * 
 */

package org.komea.product.backend.service.kpi;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.komea.product.backend.api.IEventEngineService;
import org.komea.product.backend.api.IKpiQueryService;
import org.komea.product.backend.service.ISystemProjectBean;
import org.komea.product.backend.service.entities.IEntityService;
import org.komea.product.database.dao.KpiDao;
import org.komea.product.database.dao.MeasureDao;
import org.komea.product.database.dao.ProjectDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author sleroy
 */
@RunWith(MockitoJUnitRunner.class)
public class KPIValueServiceTest
{
    
    
    @Mock
    private IEntityService      entityService;
    
    
    @Mock
    private IEventEngineService esperEngine;
    
    
    @Mock
    private KpiDao              kpiDAO;
    
    
    @Mock
    private IKpiQueryService    kpiQueryRegistry;
    
    
    @InjectMocks
    private KPIValueService     kPIValueService;
    
    
    @Mock
    private MeasureDao          measureService;
    @Mock
    private ProjectDao          projectDao;
    
    
    @Autowired
    private ISystemProjectBean  systemProjectBean;
    
    
    
    /**
     * Test method for
     * {@link org.komea.product.cep.tester.KPIValueService#getAllRealTimeMeasuresPerEntityAndPerKpi(java.util.List, java.util.List)}.
     */
    @Test
    public final void testGetAllRealTimeMeasuresPerEntityAndPerKpi() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
    
    /**
     * Test method for
     * {@link org.komea.product.cep.tester.KPIValueService#getLastMeasureOfKpi(org.komea.product.database.model.Kpi, org.komea.product.database.api.IEntity)}
     * .
     */
    @Test
    public final void testGetLastMeasureInHistoryOfAKpi() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
    
    /**
     * Test method for {@link org.komea.product.cep.tester.KPIValueService#getRealTimeMeasure(org.komea.product.service.dto.KpiKey)}.
     */
    @Test
    public final void testGetRealTimeMeasure() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
    
    /**
     * Test method for {@link org.komea.product.cep.tester.KPIValueService#getSingleValue(org.komea.product.service.dto.KpiKey)}.
     */
    @Test
    public final void testGetSingleValue() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
    
    /**
     * Test method for {@link org.komea.product.cep.tester.KPIValueService#storeActualValueInHistory(org.komea.product.service.dto.KpiKey)}.
     */
    @Test
    public final void testStoreValueInHistory() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
    
    /**
     * Test method for
     * {@link org.komea.product.cep.tester.KPIValueService#storeValueInKpiHistory(org.komea.product.service.dto.KpiKey, java.lang.Number)} .
     */
    @Test
    public final void testStoreValueInKpiHistory() throws Exception {
    
    
        // TODO
        // org.junit.Assert.assertTrue("not yet implemented", false);
    }
    
}
