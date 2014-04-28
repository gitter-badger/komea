package org.komea.product.web.rest.api;

import java.util.List;
import org.komea.product.backend.service.entities.IEntityService;
import org.komea.product.database.api.IEntity;
import org.komea.product.database.dto.BaseEntityDto;
import org.komea.product.database.enums.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(
        value = "/entities")
public class EntitiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntitiesController.class);

    @Autowired
    private IEntityService entityService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/type")
    @ResponseBody
    public List<BaseEntityDto> getEntities(@RequestBody
            final EntityType _entityType) {
        LOGGER.debug("call rest method /entities/type/ with body: " + _entityType);
        List<? extends IEntity> entities = entityService.getEntitiesByEntityType(_entityType);
        LOGGER.debug("return entities: " + entities);
        return BaseEntityDto.convertEntities(entities);

    }

}
