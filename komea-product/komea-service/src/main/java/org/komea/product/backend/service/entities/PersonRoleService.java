/**
 * 
 */

package org.komea.product.backend.service.entities;



import org.apache.commons.lang.Validate;
import org.komea.product.backend.genericservice.AbstractService;
import org.komea.product.database.dao.IGenericDAO;
import org.komea.product.database.dao.PersonRoleDao;
import org.komea.product.database.model.PersonRole;
import org.komea.product.database.model.PersonRoleCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author sleroy
 */
@Transactional
@Service
public class PersonRoleService extends AbstractService<PersonRole, Integer, PersonRoleCriteria>
        implements IPersonRoleService
{
    
    
    @Autowired
    private PersonRoleDao requiredDAO;
    
    
    
    /**
     * Returns the default user role
     * 
     * @return the default user role.
     */
    @Override
    public PersonRole getAdminRole() {
    
    
        final PersonRole singleOrNull = selectByKey("ADMIN");
        Validate.notNull(singleOrNull);
        return singleOrNull;
    }
    
    
    /**
     * Returns the default user role
     * 
     * @return the default user role.
     */
    @Override
    public PersonRole getDefaultUserRole() {
    
    
        final PersonRole selectByKey = selectByKey("USER");
        Validate.notNull(selectByKey);
        return selectByKey;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.genericservice.AbstractService#getRequiredDAO()
     */
    @Override
    public IGenericDAO<PersonRole, Integer, PersonRoleCriteria> getRequiredDAO() {
    
    
        return requiredDAO;
    }
    
    
    public void setRequiredDAO(final PersonRoleDao _requiredDAO) {
    
    
        requiredDAO = _requiredDAO;
    }
    
    
    @Override
    protected PersonRoleCriteria createKeyCriteria(final String key) {
    
    
        final PersonRoleCriteria criteria = new PersonRoleCriteria();
        criteria.createCriteria().andRoleKeyEqualTo(key);
        return criteria;
    }
    
    
}
