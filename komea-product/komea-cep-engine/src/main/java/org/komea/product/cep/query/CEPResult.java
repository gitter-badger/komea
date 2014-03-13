/**
 * 
 */

package org.komea.product.cep.query;



import org.apache.commons.lang.Validate;
import org.komea.product.cep.api.CEPResultType;
import org.komea.product.cep.api.ICEPResult;
import org.komea.product.cep.api.ITupleResultMap;



/**
 * This class returns the result expected from a query
 * 
 * @author sleroy
 */
public class CEPResult
{
    
    
    /**
     * Returns a CEP Result as a number.
     * 
     * @param _value
     *            the number
     * @return the result
     */
    public static ICEPResult buildFromCustomType(final Object _value) {
    
    
        return new CEPCustomTypeResult(_value);
    }
    
    
    /**
     * Creates the result wrapper from its definition.
     */
    public static ICEPResult buildFromDefinition(
            final CEPResultType _resultType,
            final Object _value) {
    
    
        switch (_resultType) {
            case NUMERICAL:
                return buildFromNumber((Number) _value);
            case TABLE:
                return buildFromMap((ITupleResultMap) _value);
            case CUSTOM:
                return buildFromCustomType(_value);
        }
        return null;
    }
    
    
    /**
     * Returns a CEP Result as a number.
     * 
     * @return
     */
    public static ICEPResult buildFromMap(final ITupleResultMap _iResultMap) {
    
    
        Validate.notNull(_iResultMap);
        return new CEPMapResult(_iResultMap);
    }
    
    
    /**
     * Returns a CEP Result as a number.
     * 
     * @param _value
     *            the number
     * @return the cep result.
     */
    public static ICEPResult buildFromNumber(final Number _value) {
    
    
        Validate.notNull(_value);
        return new CEPNumericalResult(_value);
    }
    
    
    private CEPResult() {
    
    
    }
    
}