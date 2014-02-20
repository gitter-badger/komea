/**
 * 
 */

package org.komea.product.backend.service.esper;



import java.util.Comparator;

import org.komea.product.database.alert.IEvent;



/**
 * @author sleroy
 */
public class EventDateComparator implements Comparator<IEvent>
{
    
    
    /*
     * (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(final IEvent _arg0, final IEvent _arg1) {
    
    
        return _arg0.getDate().compareTo(_arg1.getDate());
    }
    
}