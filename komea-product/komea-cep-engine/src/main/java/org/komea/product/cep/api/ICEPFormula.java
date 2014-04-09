/**
 * 
 */

package org.komea.product.cep.api;



import java.io.Serializable;
import java.util.Map;



/**
 * This class defines the formula that is employed by the query to compute its result.
 * 
 * @author sleroy
 */
public interface ICEPFormula<TEvent extends Serializable>
{
    
    
    /**
     * Compute the value.
     * 
     * @param _statement
     *            the statement
     * @param the
     *            parameters
     * @return the result.
     */
    ICEPResult compute(ICEPStatement<TEvent> _statement, Map<String, Object> _parameters);
    
    
}
