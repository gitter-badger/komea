/**
 * 
 */

package org.komea.eventory.api.filters;



import java.io.Serializable;



/**
 * @author sleroy
 * @param T
 *            type of event expected in input.
 * @param R
 *            type of information once transformed.
 */
public interface IEventTransformer<T extends Serializable, R extends Serializable>
{
    
    
    /**
     * Transform an event into another one.
     * 
     * @param _event
     *            the event.
     * @return the transformed information.
     */
    ITransformedEvent<R> transform(T _event);
}