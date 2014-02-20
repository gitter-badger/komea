
package org.komea.product.backend.service.esper;



import java.util.Date;

import org.komea.product.backend.api.IEsperEngine;
import org.komea.product.database.alert.IEvent;
import org.komea.product.database.dto.EventSimpleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 */
@Service
public class EventPushService implements IEventPushService
{
    
    
    @Autowired
    private IEsperEngine                         esperEngine;
    
    
    @Autowired
    private IEventConversionAndValidationService validator;
    
    
    private static final Logger                  LOGGER = LoggerFactory
                                                                .getLogger(EventPushService.class);
    
    
    
    public EventPushService() {
    
    
        super();
    }
    
    
    /**
     * Method sendEvent.
     * @param _event IEvent
     * @see org.komea.product.backend.service.esper.IEventPushService#sendEvent(IEvent)
     */
    @Override
    public void sendEvent(final IEvent _event) {
    
    
        validator.validate(_event);
        sendEventWithoutValidation(_event);
        
    }
    
    
    /**
     * Method sendEventDto.
     * @param _dto EventSimpleDto
     * @see org.komea.product.backend.service.esper.IEventPushService#sendEventDto(EventSimpleDto)
     */
    @Override
    public void sendEventDto(final EventSimpleDto _dto) {
    
    
        final IEvent convert = validator.convert(_dto);
        sendEvent(convert);
        
    }
    
    
    /**
     * Method sendEventWithoutValidation.
     * @param _event IEvent
     */
    public void sendEventWithoutValidation(final IEvent _event) {
    
    
        if (_event.getDate() == null) {
            _event.setDate(new Date());
        }
        
        if (!_event.getEventType().getEnabled()) {
            LOGGER.trace("Event discarded since event type (} is disabled", _event.getEventType()
                    .getName());
        }
        esperEngine.sendEvent(_event);
        
        
    }
    
    
    /**
     * Method setEsperEngine.
     * @param _esperEngine IEsperEngine
     */
    public void setEsperEngine(final IEsperEngine _esperEngine) {
    
    
        esperEngine = _esperEngine;
    }
    
    
    /**
     * Method setValidator.
     * @param _validator IEventConversionAndValidationService
     */
    public void setValidator(final IEventConversionAndValidationService _validator) {
    
    
        validator = _validator;
    }
    
}