/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.komea.product.wicket.persongroup.department;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.komea.product.backend.service.entities.IPersonGroupService;
import org.komea.product.database.dto.DepartmentDto;
import org.komea.product.database.model.PersonGroup;
import org.komea.product.database.model.Project;
import org.komea.product.wicket.LayoutPage;
import org.komea.product.wicket.persongroup.PersonGroupDeleteAction;
import org.komea.product.wicket.project.ProjectDeleteAction;
import org.komea.product.wicket.project.ProjectEditAction;
import org.komea.product.wicket.widget.api.IDeleteAction;
import org.komea.product.wicket.widget.api.IEditAction;
import org.komea.product.wicket.widget.builders.DataTableBuilder;

/**
 *
 * @author rgalerme
 */
public final class DepartmentPage extends LayoutPage {

    @SpringBean
    private IPersonGroupService personGroupService;

    public DepartmentPage(PageParameters _parameters) {
        super(_parameters);
        
        final IDeleteAction<PersonGroup> personGroupDeleteAction = new PersonGroupDeleteAction(personGroupService);
        final IEditAction<PersonGroup> personGroupEditAction = new DepartmentEditAction(this);

        final ISortableDataProvider<PersonGroup, String> dataProvider = new DepartmentDataModel(personGroupService);
        final DataTable<PersonGroup, String> build
                = DataTableBuilder.<PersonGroup, String>newTable("table").addColumn("Department Key", "PersonGroupKey")
                .addColumn("Name", "Name").addColumn("Description", "Description")
                .withEditDeleteColumn(personGroupDeleteAction, personGroupEditAction)
                .displayRows(10)
                .withData(dataProvider).build();
        add(build);

    }

}