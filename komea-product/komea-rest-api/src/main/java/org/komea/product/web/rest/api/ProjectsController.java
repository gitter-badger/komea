
package org.komea.product.web.rest.api;


import java.util.List;

import org.komea.product.backend.service.entities.IProjectService;
import org.komea.product.database.dto.ProjectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/projects")
public class ProjectsController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsController.class);
    
    @Autowired
    private IProjectService     entityService;
    
    /**
     * This method return the project list
     * 
     * @return the project list
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    public List<ProjectDto> allProjects() {
    
        LOGGER.debug("call rest method /projects/all/");
        return entityService.getAllProjectsAsDtos();
    }
    
}
