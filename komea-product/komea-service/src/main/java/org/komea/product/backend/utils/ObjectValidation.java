/**
 * 
 */

package org.komea.product.backend.utils;



import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.komea.product.backend.exceptions.KomeaConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * This object performs validation with JSR 330.
 * 
 * @author sleroy
 */
public class ObjectValidation
{
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectValidation.class);
    
    private final Validator     validator;
    
    
    
    /**
     * 
     */
    public ObjectValidation() {
    
    
        super();
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        
    }
    
    
    /**
     * Method validationObject.
     * 
     * @param _object
     *            T
     */
    public <T> void validateObject(final T _object) {
    
    
        final Set<ConstraintViolation<T>> constraintViolationException =
                validator.validate(_object);
        
        if (!constraintViolationException.isEmpty()) {
            LOGGER.error("Invalid event has been received : {}", _object);
            throw new KomeaConstraintViolationException(new HashSet<ConstraintViolation<?>>(
                    constraintViolationException));
        }
    }
}