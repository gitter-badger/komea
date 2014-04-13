/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.komea.product.plugins.bugzilla.api;

import java.io.Closeable;
import java.util.List;

import org.komea.product.plugins.bugzilla.model.BugzillaBug;

/**
 *
 * @author rgalerme
 */
public interface IBZServerProxy extends Closeable {

    /**
     *
     * @return
     */
    public List<String> getListProjects();

    /**
     * get list of bugs in bugzilla server
     *
     * @param Project
     * @return
     */
    public List<BugzillaBug> getListBugs(String Project);

    public List<String> getSeverities();

    public List<String> getPriorities();

}