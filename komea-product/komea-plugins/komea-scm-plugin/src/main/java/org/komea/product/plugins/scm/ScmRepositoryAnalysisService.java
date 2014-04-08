
package org.komea.product.plugins.scm;



import java.util.List;

import org.apache.commons.lang.Validate;
import org.joda.time.DateTime;
import org.komea.product.backend.service.entities.IPersonService;
import org.komea.product.backend.service.esper.IEventPushService;
import org.komea.product.database.dto.EventSimpleDto;
import org.komea.product.plugins.scm.api.IScmRepositoryAnalysisService;
import org.komea.product.plugins.scm.api.plugin.IScmCommit;
import org.komea.product.plugins.scm.api.plugin.IScmRepositoryProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Fetchs the new feeds and produces alerts.
 * 
 * @author sleroy
 */

public class ScmRepositoryAnalysisService implements IScmRepositoryAnalysisService
{
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger("scm-repository-analysis");
    
    @Autowired
    private IEventPushService   esperEngine;
    
    @Autowired
    private IPersonService      personService;
    
    
    
    /**
     * Builds the object
     * 
     * @param _fetch
     *            the rss fedd
     * @param _lastDate
     *            the last fetched date.
     * @param _gitCloner
     */
    
    public ScmRepositoryAnalysisService() {
    
    
        super();
    }
    
    
    /*
     * (non-Javadoc)
     * @see
     * org.komea.product.plugins.scm.api.IScmRepositoryAnalysisService#analysis(org.komea.product.plugins.scm.api.plugin.IScmRepositoryProxy
     * )
     */
    @Override
    public void analysis(final IScmRepositoryProxy _newProxy) {
    
    
        Validate.notNull(_newProxy);
        
        LOGGER.info("Differential analysis of the scm repository {}", _newProxy
                .getRepositoryDefinition().getRepoName());
        
        try {
            // Begin gitRepositoryDefinition
            esperEngine.sendEventDto(_newProxy.getEventFactory().sendFetchRepository());
            
            checkNumberOfBranches(_newProxy);
            for (final String branchName : _newProxy.getBranches()) {
                checkNumberOfTagsPerBranch(_newProxy, branchName);
                
                checkNewCommits(_newProxy, branchName);
            }
            
            
        } catch (final Throwable e) {
            LOGGER.error(e.getMessage(), e);
            esperEngine.sendEventDto(_newProxy.getEventFactory().sendFetchFailed());
        }
        
    }
    
    
    /**
     * Checks new commit from a branch.
     * 
     * @param _newProxy
     *            the proxy
     * @param _branchName
     *            the branch name
     */
    public void checkNewCommits(final IScmRepositoryProxy _newProxy, final String _branchName) {
    
    
        final DateTime lastDate = _newProxy.getRepositoryDefinition().getLastDateCheckoutOrNull();
        final List<IScmCommit> allCommitsFromABranch =
                _newProxy.getAllCommitsFromABranch(_branchName, lastDate);
        for (final IScmCommit commit : allCommitsFromABranch) {
            Validate.isTrue(lastDate.isBefore(commit.getCommitTime()));
            notifyEvent(_newProxy.getEventFactory().sendNewCommit(commit.getMessage(),
                    commit.getAuthor(), commit.getId()));
        }
        
    }
    
    
    /**
     * Check the number of branches.
     * 
     * @param _newProxy
     */
    public void checkNumberOfBranches(final IScmRepositoryProxy _newProxy) {
    
    
        notifyEvent(_newProxy.getEventFactory().sendBranchNumbers(_newProxy.getBranches().size()));
    }
    
    
    /**
     * Check the number of tags per branch
     * 
     * @param _newProxy
     * @param branchName
     */
    public void checkNumberOfTagsPerBranch(
            final IScmRepositoryProxy _newProxy,
            final String branchName) {
    
    
        final int size = _newProxy.getAllTagsFromABranch(branchName).size();
        notifyEvent(_newProxy.getEventFactory().sendNumberTagPerBranch(size, branchName));
    }
    
    
    /**
     * @return the esperEngine
     */
    public IEventPushService getEsperEngine() {
    
    
        return esperEngine;
    }
    
    
    // http://stackoverflow.com/questions/12493916/getting-commit-information-from-a-revcommit-object-in-jgit
    // http://stackoverflow.com/questions/10435377/jgit-how-to-get-branch-when-traversing-repos
    
    
    /**
     * @return the personService
     */
    public IPersonService getPersonService() {
    
    
        return personService;
    }
    
    
    /**
     * @param _esperEngine
     *            the esperEngine to set
     */
    public void setEsperEngine(final IEventPushService _esperEngine) {
    
    
        esperEngine = _esperEngine;
    }
    
    
    // http://stackoverflow.com/questions/12493916/getting-commit-information-from-a-revcommit-object-in-jgit
    // http://stackoverflow.com/questions/10435377/jgit-how-to-get-branch-when-traversing-repos
    
    /**
     * @param _personService
     *            the personService to set
     */
    public void setPersonService(final IPersonService _personService) {
    
    
        personService = _personService;
    }
    
    
    /**
     * Notify that an event has been sent.
     * 
     * @param _event
     *            the event
     */
    void notifyEvent(final EventSimpleDto _event) {
    
    
        esperEngine.sendEventDto(_event);
        
    }
}