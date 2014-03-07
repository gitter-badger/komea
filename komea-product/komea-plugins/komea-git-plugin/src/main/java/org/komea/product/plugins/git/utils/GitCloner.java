
package org.komea.product.plugins.git.utils;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.Validate;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.TextProgressMonitor;
import org.komea.product.plugins.git.model.GitRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GitCloner
{
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GitCloner.class);
    private Repository          fileRepository;
    
    private Git                 git;
    private final GitRepo       gitRepo;
    private File                gitRepositoryFolder;
    private final File          storageFolder;
    
    
    
    /**
     * Builds the repository.
     * 
     * @param _storageFolder
     * @param _repositoryName
     * @param _repositoryURL
     */
    public GitCloner(final File _storageFolder, final GitRepo _gitRepo) {
    
    
        super();
        Validate.notNull(_storageFolder);
        Validate.notNull(_gitRepo);
        Validate.notNull(_gitRepo.getId());
        storageFolder = _storageFolder;
        gitRepo = _gitRepo;
    }
    
    
    public Git getGit() {
    
    
        return git;
    }
    
    
    public File getGitRepositoryFolder() {
    
    
        return gitRepositoryFolder;
    }
    
    
    public Repository getRepository() {
    
    
        return fileRepository;
    }
    
    
    public File getStorageFolder() {
    
    
        return storageFolder;
    }
    
    
    public void initRepository() {
    
    
        initializeStorageFolder();
        try {
            final CloneCommand cloneRepository = Git.cloneRepository();
            
            cloneRepository.setCloneAllBranches(true);
            cloneRepository.setNoCheckout(true);
            
            cloneRepository.setProgressMonitor(new TextProgressMonitor());
            git = cloneRepository.setURI(gitRepo.getUrl()).setDirectory(gitRepositoryFolder).call();
        } catch (final Exception e) {
            throw new IllegalArgumentException(e);
        }
        fileRepository = git.getRepository();
        
    }
    
    
    public void setGitRepositoryFolder(final File _gitRepositoryFolder) {
    
    
        gitRepositoryFolder = _gitRepositoryFolder;
    }
    
    
    private void initializeStorageFolder() {
    
    
        gitRepositoryFolder = new File(storageFolder, "repo" + gitRepo.getId());
        try {
            FileUtils.deleteDirectory(gitRepositoryFolder);
        } catch (final IOException e) {
            LOGGER.error("Could not delete the folder : {}", gitRepositoryFolder);
        }
        
        if (!gitRepositoryFolder.exists() && !gitRepositoryFolder.mkdirs()) { throw new IllegalArgumentException(
                "Could not create " + gitRepositoryFolder); }
        
        gitRepositoryFolder.deleteOnExit();
    }
}
