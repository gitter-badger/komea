/**
 *
 */

package org.komea.product.backend.batch;



import org.apache.commons.lang.Validate;
import org.joda.time.DateTime;
import org.komea.product.backend.utils.IFilter;
import org.komea.product.database.dto.BugBugZilla;
import org.komea.product.plugins.bugtracking.model.IIssue;
import org.komea.product.plugins.bugzilla.api.IBugZillaToIssueConvertor;



/**
 * This filter wraps another filter and modify the issue to reflect time changes on an issue.
 *
 * @author sleroy
 */
public class RebuildFilter implements IFilter<IIssue>
{
    
    
    private DateTime                        checkTime;
    private final IBugZillaToIssueConvertor convertor;
    
    private final IFilter<IIssue>           filter;
    
    
    
    public RebuildFilter(final IFilter<IIssue> _filter, final IBugZillaToIssueConvertor _convertor) {
    
    
        super();
        filter = _filter;
        convertor = _convertor;
        Validate.notNull(filter);
        Validate.notNull(convertor);
    }
    
    
    public DateTime getCheckTime() {


        return checkTime;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.utils.IFilter#matches(java.lang.Object)
     */
    @Override
    public boolean matches(final IIssue _task) {
    
    
        if (checkTime == null) {
            return filter.matches(_task);
        }
        final BugBugZilla bugBugZilla = (BugBugZilla) _task;
        final BugBugZilla bugBugZilla2 = new BugBugZilla();
        
        bugBugZilla2.setAttributes(bugBugZilla.getAttributes());
        bugBugZilla2.setBugzillaDao(bugBugZilla.getBugzillaDao());
        bugBugZilla2.setBzServerConfiguration(bugBugZilla.getBzServerConfiguration());
        bugBugZilla2.setHistory(bugBugZilla.getHistory());
        bugBugZilla2.setPersonService(bugBugZilla.getPersonService());
        bugBugZilla2.setProject(bugBugZilla.getProject());
        
        new RollBackStatus(bugBugZilla2, bugBugZilla.getHistory()).rollback(checkTime);
        return filter.matches(bugBugZilla2);
    }
    
    
    public void setCheckTime(final DateTime _checkTime) {


        checkTime = _checkTime;
    }
    
    
}