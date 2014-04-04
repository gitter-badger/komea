/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.komea.product.plugins.bugzilla.api;

import org.komea.product.plugins.bugzilla.data.BugZillaServer;

/**
 *
 * @author rgalerme
 */
public interface IBugZillaServerProxyFactory {

    public IBugZillaServerProxy newConnector(BugZillaServer serv);


}