
package org.komea.product.database.dto;



import java.io.Serializable;
import java.util.List;

import org.komea.product.database.model.EventType;
import org.komea.product.database.model.Provider;



public class ProviderDto implements Serializable
{
    
    
    private static final long serialVersionUID = 1L;
    
    private Provider          provider;
    private List<EventType>   eventTypes;
    private List<PropertyDTO> properties;
    
    
    
    public ProviderDto() {
    
    
        super();
    }
    
    
    public ProviderDto(final Provider provider, final List<EventType> eventTypes) {
    
    
        this.provider = provider;
        this.eventTypes = eventTypes;
    }
    
    
    public List<EventType> getEventTypes() {
    
    
        return eventTypes;
    }
    
    
    public List<PropertyDTO> getProperties() {
    
    
        return properties;
    }
    
    
    public Provider getProvider() {
    
    
        return provider;
    }
    
    
    public void setEventTypes(final List<EventType> eventTypes) {
    
    
        this.eventTypes = eventTypes;
    }
    
    
    public void setProperties(final List<PropertyDTO> _properties) {
    
    
        properties = _properties;
    }
    
    
    public void setProvider(final Provider provider) {
    
    
        this.provider = provider;
    }
    
}
