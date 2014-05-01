/**
 * 
 */

package org.komea.eventory.formula;



import java.io.Serializable;
import java.util.Map;

import org.apache.commons.jxpath.BasicVariables;
import org.apache.commons.jxpath.JXPathContext;
import org.komea.eventory.api.engine.ICEPStatement;
import org.komea.eventory.api.formula.ICEPFormula;
import org.komea.eventory.query.xpath.XPathTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author sleroy
 */
public class XPathFormula<TRes> implements ICEPFormula<Serializable, TRes>
{
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger("xpath-formula");
    
    
    private final String        xpathFormula;
    
    
    
    /**
     * Builds an XPath Formula.
     */
    public XPathFormula(final String _xpathFormula) {
    
    
        xpathFormula = _xpathFormula;
        
    }
    
    
    /**
     * Builds the JXpath context.
     * 
     * @param _parameters
     *            the parameters
     * @param xPathTree
     *            the xpath tree
     * @return the jxpath context
     */
    public JXPathContext buildJXpathContext(
            final Map<String, Object> _parameters,
            final XPathTree xPathTree) {
    
    
        final JXPathContext newContext = JXPathContext.newContext(xPathTree);
        final BasicVariables vars = buildXPathVariables(_parameters);
        newContext.setVariables(vars);
        return newContext;
    }
    
    
    /**
     * Builds JXpath variables from parameters
     * 
     * @param _parameters
     *            the parameters.
     * @return
     */
    public BasicVariables buildXPathVariables(final Map<String, Object> _parameters) {
    
    
        final BasicVariables vars = new BasicVariables();
        for (final java.util.Map.Entry<String, Object> entry : _parameters.entrySet()) {
            vars.declareVariable(entry.getKey(), entry.getValue());
        }
        return vars;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.cep.api.ICEPFormula#compute(org.komea.product.cep.api.ICEPStatement, java.util.Map)
     */
    @Override
    public TRes compute(
            final ICEPStatement<Serializable> _statement,
            final Map<String, Object> _parameters) {
    
    
        final XPathTree xPathTree = new XPathTree(_statement);
        System.out.println(xPathTree.dumpTree());
        return executeQuery(_parameters, xPathTree);
    }
    
    
    public TRes executeQuery(final Map<String, Object> _parameters, final XPathTree xPathTree) {
    
    
        final JXPathContext newContext = buildJXpathContext(_parameters, xPathTree);
        
        final Object value = newContext.getValue(xpathFormula);
        LOGGER.trace("returns {}", value);
        return (TRes) value; // UNSAFE CAST
    }
}
