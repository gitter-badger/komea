
package org.komea.product.rest.client;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.komea.product.database.dto.ProjectDto;
import org.komea.product.rest.client.api.IProjectsAPI;

public class ProjectsAPIIT extends AbstractRestClientIntegrationTestCase {
    
    @Before
    public void setUp() throws Exception {
    
    }
    //
    
    @Test
    public void testAllProjects() throws Exception {
    
        IProjectsAPI projectsAPI = RestClientFactory.INSTANCE.createProjectsAPI("http://localhost:8585/komea");
        Assert.assertNotNull(projectsAPI);
        List<ProjectDto> projects = projectsAPI.allProjects();
        Assert.assertFalse(projects.isEmpty());
    }
}
