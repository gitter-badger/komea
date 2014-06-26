
package org.komea.product.backend.api.exceptions;



import org.komea.product.database.enums.EntityType;
import org.komea.product.service.dto.EntityKey;
import org.komea.product.service.dto.EntityStringKey;



/**
 */
public class EntityNotFoundException extends RuntimeException
{
    
    
    /**
     * @param _entityKey
     */
    public EntityNotFoundException(final EntityKey _entityKey) {
    
    
        this(_entityKey.getId(), _entityKey.getEntityType());
    }
    
    
    public EntityNotFoundException(final EntityStringKey _entityKey) {
    
    
        this(_entityKey.getKey(), _entityKey.getEntityType());
    }
    
    
    /**
     * Constructor for EntityNotFoundException.
     *
     * @param _entityID
     *            int
     * @param _entityType
     *            EntityType
     */
    public EntityNotFoundException(final Integer _entityID, final EntityType _entityType) {
    
    
        super("Entity not found " + _entityID + " type " + _entityType);
    }
    
    
    public EntityNotFoundException(final String _key, final EntityType _entityType) {
    
    
        super("Entity not found " + _key + " type " + _entityType);
    }
}
