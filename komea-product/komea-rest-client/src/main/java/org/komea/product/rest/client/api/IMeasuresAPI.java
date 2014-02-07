
package org.komea.product.rest.client.api;


import java.net.ConnectException;

import org.komea.product.service.dto.KpiKey;
import org.komea.product.service.dto.errors.InternalServerException;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Komea rest api client to manage measures
 * <p>
 * 
 * @author $Author: jguidoux $
 * @since 7 févr. 2014
 */
public interface IMeasuresAPI
{
    
    /**
     * This method get the last measure for a kpi type on an entity
     * 
     * @param _kpiKey
     *            the kpi type
     * @param _entityKey
     *            the entity
     * @return the last measure value
     * @throws ConnectException
     *             launch if it can't connect to the server
     */
    double lastMeasuresForEntity(@RequestBody final KpiKey _kpiKey) throws InternalServerException, ConnectException;
}
