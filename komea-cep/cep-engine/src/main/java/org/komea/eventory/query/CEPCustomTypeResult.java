/**
 * 
 */

package org.komea.eventory.query;



import org.komea.eventory.api.formula.ICEPResult;
import org.komea.eventory.api.formula.ITupleResultMap;



/**
 * This class returns the result expected from a query
 * 
 * @author sleroy
 */
public class CEPCustomTypeResult<T> implements ICEPResult
{
    
    
    private T value = null;
    
    
    
    public CEPCustomTypeResult(final T _value) {
    
    
        super();
        value = _value;
        
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPResult#asMap()
     */
    @Override
    public <Tres> ITupleResultMap<Tres> asMap() {
    
    
        throw new IllegalArgumentException(
                "Cannot convert to a map, the current result type is undefined/custom.");
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPResult#asNumber()
     */
    @Override
    public Number asNumber() {
    
    
        throw new IllegalArgumentException(
                "Cannot convert to a number, the current result type is undefined/custom.");
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPResult#asNumber()
     */
    @Override
    public <T2> T2 asType() {
    
    
        return (T2) value;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPResult#isMap()
     */
    @Override
    public boolean isMap() {
    
    
        return false;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPResult#isNumericalValue()
     */
    @Override
    public boolean isNumericalValue() {
    
    
        return false;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.eventory.api.ICEPResult#isNumericalValue()
     */
    @Override
    public boolean isSingleValue() {
    
    
        return true;
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    
    
        return "CEPCustomTypeResult [value=" + value + "]";
    }
    
    
}