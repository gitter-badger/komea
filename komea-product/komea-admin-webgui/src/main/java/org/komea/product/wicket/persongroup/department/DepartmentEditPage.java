/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.komea.product.wicket.persongroup.department;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.komea.product.backend.service.entities.IPersonGroupService;
import org.komea.product.backend.service.entities.IPersonService;
import org.komea.product.backend.service.entities.IProjectService;
import org.komea.product.database.model.PersonGroup;
import org.komea.product.wicket.StatelessLayoutPage;

/**
 *
 * @author rgalerme
 */
public final class DepartmentEditPage extends StatelessLayoutPage {

    @SpringBean
    private IPersonGroupService prService;

    @SpringBean
    private IPersonService personService;
    
    @SpringBean
    private IProjectService projectService;

    public DepartmentEditPage(PageParameters _parameters) {
        this(_parameters, new PersonGroup(), true);
    }

    public DepartmentEditPage(PageParameters _parameters, PersonGroup _personGroup) {
        this(_parameters, _personGroup, false);
    }

    private DepartmentEditPage(PageParameters _parameters, PersonGroup _personGroup, boolean isNew) {
        super(_parameters);

        final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        feedbackPanel.setOutputMarkupId(true);
        feedbackPanel.setOutputMarkupPlaceholderTag(true);
        add(feedbackPanel);
        
        final DepartmentForm departmentForm = new DepartmentForm(projectService,personService, isNew, "form", prService,
                feedbackPanel, new CompoundPropertyModel<PersonGroup>(_personGroup), this);
        String message;
        if (isNew) {
            message = getString("departmentpage.save.add.title");
        } else {
            message = getString("departmentpage.save.edit.title");
        }
        departmentForm.add(new Label("legend", message));
        add(departmentForm);
    }

    @Override
    public String getTitle() {
        return getString("departmentpage.main.title");
    }
}
