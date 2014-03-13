
package org.komea.product.plugins.git.bean;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.komea.product.backend.api.PluginAdminPages;
import org.komea.product.backend.api.PluginMountPage;
import org.komea.product.backend.plugin.api.EventTypeDef;
import org.komea.product.backend.plugin.api.ProviderPlugin;
import org.komea.product.backend.service.ISettingService;
import org.komea.product.backend.service.cron.ICronRegistryService;
import org.komea.product.backend.service.entities.IPersonService;
import org.komea.product.backend.service.esper.IEventPushService;
import org.komea.product.database.enums.EntityType;
import org.komea.product.database.enums.ProviderType;
import org.komea.product.database.enums.Severity;
import org.komea.product.database.model.Setting;
import org.komea.product.plugins.git.cron.GitScheduleCronJob;
import org.komea.product.plugins.git.repositories.api.IGitClonerService;
import org.komea.product.plugins.git.repositories.api.IGitRepositoryService;
import org.quartz.JobDataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Main class to define the GIT Provider Plugin.
 * 
 * @author sleroy
 */
@ProviderPlugin(
        eventTypes = {
                @EventTypeDef(
                        category = "SCM",
                        description = "A new commit has been pushed on a GIT Server",
                        enabled = true,
                        entityType = EntityType.PROJECT,
                        key = "scm-new-commit",
                        name = "New commit on git server",
                        severity = Severity.INFO),
                @EventTypeDef(
                        category = "SCM",
                        description = "Fetch on git server has failed",
                        enabled = true,
                        entityType = EntityType.PROJECT,
                        key = "scm-fetch-failed",
                        name = "Fetch on git server has failed.",
                        severity = Severity.INFO),
                @EventTypeDef(
                        category = "SCM",
                        description = "Number of tags in a git branch. The plugin will try to detect how many tags are present on the git branch.",
                        enabled = true,
                        entityType = EntityType.PROJECT,
                        key = "scm-tag-perbranch-numbers",
                        name = "Number of tags per branch.",
                        severity = Severity.INFO),
                @EventTypeDef(
                        category = "SCM",
                        description = "Event sent when a git repository is fetched.",
                        enabled = true,
                        entityType = EntityType.PROJECT,
                        key = "scm-fetch-repository",
                        name = "Number of tags per branch.",
                        severity = Severity.INFO),
                @EventTypeDef(
                        category = "SCM",
                        description = "Number of customer tags . This plugin will try to detect custom tags present on a git repository.",
                        enabled = true,
                        entityType = EntityType.PROJECT,
                        key = "scm-customer-tag-numbers",
                        name = "Number of customer tags.",
                        severity = Severity.INFO),
                @EventTypeDef(
                        category = "SCM",
                        description = "Number of customer branches . This plugin will try to detect the number of customer branches present on a git repository.",
                        enabled = true,
                        entityType = EntityType.PROJECT,
                        key = "scm-customer-branch-numbers",
                        name = "Number of customer branches.",
                        severity = Severity.INFO),
                @EventTypeDef(
                        category = "SCM",
                        description = "Number of branches . This plugin will try to detect the number of branches present on a git repository.",
                        enabled = true,
                        entityType = EntityType.PROJECT,
                        key = "scm-branch-numbers",
                        name = "Number of branches.",
                        severity = Severity.INFO)
        
        
        },
        
        
        icon = "git",
        name = GitProviderPlugin.GIT_PROVIDER_PLUGIN,
        type = ProviderType.NEWS,
        url = "/git-provider")
@PluginAdminPages(@PluginMountPage(
        pluginName = GitProviderPlugin.GIT_PROVIDER_PLUGIN,
        page = GitRepositoryPage.class))
public class GitProviderPlugin implements org.komea.product.backend.service.ISettingListener
{
    
    
    private static final String  GIT_CRON_JOB        = "git_cron_job";
    
    
    /**
     * Cron value for GIT Provider.
     */
    private static final String  GIT_CRON_VALUE      = "0 0/1 * * * ?";
    
    
    private static final String  GIT_PROVIDER_PERIOD = "git_refresh_period";
    
    
    private static final Logger  LOGGER              = LoggerFactory.getLogger("git-provider");
    
    
    /**
     * Rss Provider plugin name;
     */
    static final String          GIT_PROVIDER_PLUGIN = "GIT Provider plugin";
    
    
    @Autowired
    private ICronRegistryService cronRegistryService;
    
    
    @Autowired
    private IEventPushService    esperEngine;
    
    @Autowired
    private IGitClonerService    gitClonerService;
    
    
    @Autowired
    private IGitRepositoryService       gitRepository;
    
    
    @Autowired
    private IPersonService       personService;
    
    @Autowired
    private ISettingService      registry;
    
    
    
    /**
     * RSS Provider plugin.
     */
    public GitProviderPlugin() {
    
    
        super();
    }
    
    
    @PreDestroy
    public void destroy() {
    
    
        LOGGER.debug("Removing RSS Cron");
        cronRegistryService.removeCronTask(GIT_CRON_JOB);
    }
    
    
    /**
     * @return the cronRegistryService
     */
    public ICronRegistryService getCronRegistryService() {
    
    
        return cronRegistryService;
    }
    
    
    /**
     * @return the esperEngine
     */
    public IEventPushService getEsperEngine() {
    
    
        return esperEngine;
    }
    
    
    public IGitRepositoryService getGitRepository() {
    
    
        return gitRepository;
    }
    
    
    public IPersonService getPersonService() {
    
    
        return personService;
    }
    
    
    /**
     * @return the registry
     */
    public ISettingService getRegistry() {
    
    
        return registry;
    }
    
    
    @PostConstruct
    public void initializeProvider() {
    
    
        LOGGER.info("Initialisation du plugin RSS");
        
        
        final JobDataMap properties = prepareJobMapForCron();
        //
        registry.create(GIT_PROVIDER_PERIOD, GIT_CRON_VALUE, "java.lang.String",
                "Defines the cron value to fetch rss feeds");
        registry.registerListener(GIT_PROVIDER_PERIOD, this);
        cronRegistryService.registerCronTask(GIT_CRON_JOB, GIT_CRON_VALUE,
                GitScheduleCronJob.class, properties);
        
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.komea.product.backend.service.ISettingListener#notifyPropertyChanged(org.komea.product.database.model.Setting)
     */
    @Override
    public void notifyPropertyChanged(final Setting _setting) {
    
    
        cronRegistryService.updateCronFrequency(GIT_CRON_JOB, _setting.getValue());
        
    }
    
    
    /**
     * Prepares job map for cron.
     * 
     * @return the job data map.
     */
    public JobDataMap prepareJobMapForCron() {
    
    
        final JobDataMap properties = new JobDataMap();
        properties.put("esperEngine", esperEngine);
        properties.put("repository", gitRepository);
        properties.put("gitcloner", gitClonerService);
        properties.put("personService", personService);
        properties.put("cron", cronRegistryService);
        
        return properties;
    }
    
    
    /**
     * @param _cronRegistryService
     *            the cronRegistryService to set
     */
    public void setCronRegistryService(final ICronRegistryService _cronRegistryService) {
    
    
        cronRegistryService = _cronRegistryService;
    }
    
    
    /**
     * @param _esperEngine
     *            the esperEngine to set
     */
    public void setEsperEngine(final IEventPushService _esperEngine) {
    
    
        esperEngine = _esperEngine;
    }
    
    
    public void setGitRepository(final IGitRepositoryService _gitRepository) {
    
    
        gitRepository = _gitRepository;
    }
    
    
    public void setPersonService(final IPersonService _personService) {
    
    
        personService = _personService;
    }
    
    
    /**
     * @param _registry
     *            the registry to set
     */
    public void setRegistry(final ISettingService _registry) {
    
    
        registry = _registry;
    }
    
    
}