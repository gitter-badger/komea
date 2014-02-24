/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.komea.product.wicket.project;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.komea.product.backend.service.entities.IProjectService;
import org.komea.product.database.model.Project;
import org.komea.product.wicket.LayoutPage;
import org.komea.product.wicket.widget.api.IDeleteAction;
import org.komea.product.wicket.widget.api.IEditAction;
import org.komea.product.wicket.widget.builders.DataTableBuilder;

/**
 *
 * @author rgalerme
 */
public class ProjectPage extends LayoutPage {
    
    @SpringBean
    private IProjectService projectService;
    
    public ProjectPage(PageParameters _parameters) {
        super(_parameters);
         final IDeleteAction<Project> personDeleteAction = new ProjectDeleteAction(projectService);
        
        final IEditAction<Project> kpiEditAction = new ProjectEditAction(this);

        final ISortableDataProvider<Project, String> dataProvider = new ProjectDataModel(projectService);
        final DataTable<Project, String> build =
                DataTableBuilder.<Project, String> newTable("table").addColumn("projectkey", "ProjectKey")
                        .addColumn("name", "Name").addColumn("description", "Description")
                        .withEditDeleteColumn(personDeleteAction, kpiEditAction).displayRows(10)
                        .withData(dataProvider).build();
        add(build);
        
    }
    
}
