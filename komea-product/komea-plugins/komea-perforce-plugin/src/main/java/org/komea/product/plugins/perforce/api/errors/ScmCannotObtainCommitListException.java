/**
 * 
 */

package org.komea.product.plugins.perforce.api.errors;



import java.io.IOException;

import org.komea.product.plugins.scm.api.error.ScmRuntimeException;



/**
 * @author sleroy
 */
public class ScmCannotObtainCommitListException extends ScmRuntimeException
{
    
    
    public ScmCannotObtainCommitListException(final String _string, final Throwable _e) {
    
    
        super(_string, _e);
    }
    
}
