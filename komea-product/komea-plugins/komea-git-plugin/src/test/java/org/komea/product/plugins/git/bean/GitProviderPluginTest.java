/**
 * 
 */

package org.komea.product.plugins.git.bean;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.komea.product.backend.service.ISettingService;
import org.komea.product.backend.service.cron.ICronRegistryService;
import org.komea.product.backend.service.entities.IPersonService;
import org.komea.product.backend.service.esper.IEventPushService;
import org.komea.product.plugins.git.cron.GitCronJob;
import org.komea.product.plugins.git.cron.GitScheduleCronJob;
import org.komea.product.plugins.git.model.GitRepositoryDefinition;
import org.komea.product.plugins.git.repositories.api.IGitClonerService;
import org.komea.product.plugins.git.repositories.api.IGitRepositoryService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.quartz.JobDataMap;



/**
 * @author sleroy
 */
@RunWith(MockitoJUnitRunner.class)
public class GitProviderPluginTest
{
    
    
    @Mock
    private ICronRegistryService cronRegistryService;
    
    
    @Mock
    private IEventPushService    esperEngine;
    
    
    @Mock
    private IGitClonerService    gitClonerService;
    
    @InjectMocks
    private GitProviderPlugin    gitProviderPlugin;
    
    
    @Mock
    private IGitRepositoryService       gitRepository;
    
    
    @Mock
    private IPersonService       personService;
    @Mock
    private ISettingService      registry;
    
    
    
    @Test
    public void testExecuteJobExecutionContext() {
    
    
        final GitRepositoryDefinition gitRepo = GitRepositoryDefinition.newGitRepository("DEMO", "http://");
        
        
        final GitScheduleCronJob gitScheduleCronJob = new GitScheduleCronJob();
        
        final JobDataMap prepareJobMapForCron = gitProviderPlugin.prepareJobMapForCron();
        
        final JobDataMap prepareJobMapForCron2 =
                gitScheduleCronJob.prepareJobMapForCron(prepareJobMapForCron, gitRepo);
        
        for (final String requiredKey : GitCronJob.requiredKeys()) {
            Assert.assertTrue("provider must provide key",
                    prepareJobMapForCron2.containsKey(requiredKey));
            Assert.assertNotNull("Key " + requiredKey + " should not be null",
                    prepareJobMapForCron2.get(requiredKey));
        }
        
    }
    
    
    /**
     * Test method for {@link org.komea.product.plugins.git.bean.GitProviderPlugin#prepareJobMapForCron()}.
     */
    @Test
    public final void testPrepareJobMapForCron() throws Exception {
    
    
        final JobDataMap prepareJobMapForCron = gitProviderPlugin.prepareJobMapForCron();
        for (final String requiredKey : GitScheduleCronJob.requiredKeys()) {
            Assert.assertTrue("provider must provide key",
                    prepareJobMapForCron.containsKey(requiredKey));
            Assert.assertNotNull("Key " + requiredKey + " should not be null",
                    prepareJobMapForCron.get(requiredKey));
        }
        
        
        for (final String requiredKey : GitCronJob.requiredKeys()) {
            Assert.assertTrue("provider must provide key",
                    prepareJobMapForCron.containsKey(requiredKey));
            Assert.assertNotNull("Key " + requiredKey + " should not be null",
                    prepareJobMapForCron.get(requiredKey));
        }
        
    }
    
}