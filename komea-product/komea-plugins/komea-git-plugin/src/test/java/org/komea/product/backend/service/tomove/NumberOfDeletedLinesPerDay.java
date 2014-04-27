/**
 * 
 */

package org.komea.product.backend.service.tomove;



import java.util.Collection;

import org.komea.product.plugins.scm.api.plugin.IScmCommit;



public class NumberOfDeletedLinesPerDay
{
    
    
    private final Collection<IScmCommit> commitsOfTheDay;
    
    
    
    /**
     * @param _commitsOfTheDay
     */
    public NumberOfDeletedLinesPerDay(final Collection<IScmCommit> _commitsOfTheDay) {
    
    
        commitsOfTheDay = _commitsOfTheDay;
        
        
    }
    
    
    public int compute() {
    
    
        int res = 0;
        for (final IScmCommit commit : commitsOfTheDay) {
            res += commit.getNumberOfDeletedLines();
        }
        return res;
        
    }
    
}
