/**
 * 
 */

package org.komea.product.backend.service.entities;



import org.komea.product.backend.genericservice.AbstractService;
import org.komea.product.database.dao.ProviderDao;
import org.komea.product.database.model.Provider;
import org.komea.product.database.model.ProviderCriteria;
import org.springframework.stereotype.Service;



/**
 * This class defines a provider service.
 * 
 * @author sleroy
 */
@Service
public class ProviderService extends AbstractService<Provider, Integer, ProviderCriteria> implements
        IProviderService
{
    
    
    private ProviderDao requiredDao;
    
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.genericservice.AbstractService#getRequiredDAO()
     */
    @Override
    public ProviderDao getRequiredDAO() {
    
    
        return requiredDao;
    }
    
}
