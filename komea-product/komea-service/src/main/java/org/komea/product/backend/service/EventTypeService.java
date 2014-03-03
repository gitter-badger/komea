
package org.komea.product.backend.service;



import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.komea.product.backend.exceptions.AlreadyExistingEventTypeException;
import org.komea.product.backend.exceptions.InvalidEventTypeDescriptionException;
import org.komea.product.backend.genericservice.AbstractService;
import org.komea.product.backend.service.plugins.IEventTypeService;
import org.komea.product.database.dao.EventTypeDao;
import org.komea.product.database.dao.IGenericDAO;
import org.komea.product.database.model.EventType;
import org.komea.product.database.model.EventTypeCriteria;
import org.komea.product.database.model.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 */
@Service
@Transactional
public class EventTypeService extends AbstractService<EventType, Integer, EventTypeCriteria>
        implements IEventTypeService
{
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger("event-type-service");
    
    
    @Autowired
    private EventTypeDao        requiredDAO;
    
    
    
    public EventTypeService() {
    
    
        super();
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.genericservice.AbstractService#getRequiredDAO()
     */
    @Override
    public IGenericDAO<EventType, Integer, EventTypeCriteria> getRequiredDAO() {
    
    
        return requiredDAO;
    }
    
    
    /**
     * Builds a new criteria with the name.
     * 
     * @param _eventType
     * @return EventTypeCriteria
     */
    public EventTypeCriteria newCriteriaSelectByName(final EventType _eventType) {
    
    
        final EventTypeCriteria selectEventTypeByName = new EventTypeCriteria();
        selectEventTypeByName.createCriteria().andNameEqualTo(_eventType.getEventKey());
        return selectEventTypeByName;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.service.IEventTypeService#registerEvent(org.komea.product.database.model.Provider,
     * org.komea.product.database.model.EventType)
     */
    @Override
    public void registerEvent(@NotNull
    final Provider _provider, @Valid
    final EventType _eventType) {
    
    
        LOGGER.debug("Registering event type '{}' from provider {}", _eventType.getName(),
                _provider.getName());
        final EventTypeCriteria selectByName = newCriteriaSelectByName(_eventType);
        final int existingProvider = requiredDAO.countByCriteria(selectByName);
        if (existingProvider > 0) { throw new AlreadyExistingEventTypeException(_eventType); }
        if (_eventType.getId() != null) { throw new InvalidEventTypeDescriptionException(
                "EventType DTO should not register primary key"); }
        _eventType.setIdProvider(_provider.getId());
        saveOrUpdate(_eventType);
        
    }
    
    
    public void setRequiredDAO(final EventTypeDao _requiredDAO) {
    
    
        requiredDAO = _requiredDAO;
    }
    
}
