
package org.komea.product.web.rest.api;


import java.util.List;

import org.komea.product.backend.service.IEntityService;
import org.komea.product.database.dto.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Komea Rest api to provide persons service
 * <p>
 * 
 * @author $Author: jguidoux $
 * @since 4 févr. 2014
 */
@Controller
@RequestMapping(value = "/persons")
public class PersonsController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonsController.class);
    
    @Autowired
    private IEntityService      entityService;
    
    /**
     * This method return the person list
     * url mapping : persons/all
     * 
     * @return the person list
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    public List<PersonDto> allPersons() {
    
        LOGGER.debug("call rest method /persons/all/");
        // TODO
        return entityService.getPersonList();
    }
    
}
