/**
 * 
 */

package org.komea.product.backend.service;



import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * @author sleroy
 */
public class AdminActionServicesTest
{
    
    
    private static class TestAdminAction implements IAdminAction
    {
        
        
        /*
         * (non-Javadoc)
         * @see org.komea.product.backend.service.IAdminAction#execute()
         */
        @Override
        public void execute(final ProgressListener _progressListener) {
        
        
            System.out.println("Execute admin admin");
            
        }
        
        
        /*
         * (non-Javadoc)
         * @see org.komea.product.backend.service.IAdminAction#getActionName()
         */
        @Override
        public String getActionName() {
        
        
            return "Action demo";
        }
        
    }
    
    
    
    private final AdminActionServices adminActionServices = new AdminActionServices();
    
    
    
    /**
     * Test method for
     * {@link org.komea.product.backend.service.AdminActionServices#executeAction(org.komea.product.backend.service.IAdminAction)}.
     */
    @Test
    public final void testExecuteAction() throws Exception {
    
    
        final TestAdminAction adminAction = new TestAdminAction();
        adminActionServices.registerAdminAction(adminAction);
        Assert.assertTrue(adminActionServices.executeAction(adminAction).isEmpty());
    }
    
    
    /**
     * Test method for
     * {@link org.komea.product.backend.service.AdminActionServices#registerAdminAction(org.komea.product.backend.service.IAdminAction)}.
     */
    @Test
    public final void testRegisterAdminAction() throws Exception {
    
    
        final TestAdminAction adminAction = new TestAdminAction();
        adminActionServices.registerAdminAction(adminAction);
        assertTrue(adminActionServices.getActions().contains(adminAction));
        
    }
    
}
