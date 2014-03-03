/**
 * 
 */

package org.komea.product.service.dto;



import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.komea.product.database.enums.EntityType;



/**
 * This key defines an entity.
 * 
 * @author sleroy
 */
public class EntityKey implements Serializable
{
    
    
    /**
     * Builds an entity key
     * 
     * @param _entityType
     *            the entity type
     * @param _key
     *            the key
     * @return the key
     */
    public static EntityKey of(final EntityType _entityType, final Integer _key) {
    
    
        return new EntityKey(_entityType, _key);
    }
    
    
    
    private EntityType entityType;
    
    
    private Integer    id;
    
    
    
    /**
     * Entity Key.
     */
    public EntityKey() {
    
    
        super();
    }
    
    
    /**
     * This class builds an entity key.
     * 
     * @param _entityType
     *            entity type
     * @param _id
     *            entity id.
     */
    public EntityKey(final EntityType _entityType, final Integer _id) {
    
    
        super();
        entityType = _entityType;
        id = _id;
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
    
    
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final EntityKey other = (EntityKey) obj;
        if (entityType != other.entityType) { return false; }
        if (id == null) {
            if (other.id != null) { return false; }
        } else if (!id.equals(other.id)) { return false; }
        return true;
    }
    
    
    public EntityType getEntityType() {
    
    
        return entityType;
    }
    
    
    public Integer getId() {
    
    
        return id;
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
    
    
        final int prime = 31;
        int result = 1;
        result = prime * result + (entityType == null ? 0 : entityType.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }
    
    
    /**
     * Tests if this key refers to an entity type only.
     * 
     * @return true if this key refers to entity type.
     */
    @JsonIgnore
    public boolean isEntityReferenceKey() {
    
    
        return entityType != null && id != null;
    }
    
    
    /**
     * Tests if this key refers to an entity type only.
     * 
     * @return true if this key refers to entity type.
     */
    @JsonIgnore
    public boolean isEntityTypeKey() {
    
    
        return entityType != null && id == null;
    }
    
    
    /**
     * Tests if this key refers to an entity type only.
     * 
     * @return true if this key refers to entity type.
     */
    @JsonIgnore
    public boolean isUncompleteKey() {
    
    
        return !isEntityReferenceKey() && !isEntityTypeKey();
    }
    
    
    public void setEntityType(final EntityType _entityType) {
    
    
        entityType = _entityType;
    }
    
    
    public void setId(final Integer _id) {
    
    
        id = _id;
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    
    
        return "EntityKey [entityType=" + entityType + ", id=" + id + "]";
    }
    
}