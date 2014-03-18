
package org.komea.product.backend.service.kpi;



import org.komea.product.cep.api.ICEPQuery;



/**
 */
public interface ICEPQueryTestPredicate
{
    
    
    /**
     * Method evaluate.
     * 
     * @param _epStatement
     *            EPStatement
     */
    void evaluate(final ICEPQuery _epStatement);
}