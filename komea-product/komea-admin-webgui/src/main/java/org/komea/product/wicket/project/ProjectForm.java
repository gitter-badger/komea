/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.komea.product.wicket.project;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.komea.product.backend.service.entities.IProjectService;
import org.komea.product.database.model.Project;
import org.komea.product.wicket.LayoutPage;
import org.komea.product.wicket.kpis.KpiPage;
import org.komea.product.wicket.widget.builders.AjaxLinkLayout;
import org.komea.product.wicket.widget.builders.TextAreaBuilder;
import org.komea.product.wicket.widget.builders.TextFieldBuilder;

/**
 *
 * @author rgalerme
 */
public class ProjectForm extends Form<Project> {
    
    private final IProjectService prService;
    private final Component feedBack;
    private final LayoutPage page;
    private final Project project;
    
    public ProjectForm(String form, IProjectService projectService, FeedbackPanel feedbackPanel, CompoundPropertyModel<Project> compoundPropertyModel, ProjectEditPage aThis) {
        super(form, compoundPropertyModel);
        this.prService = projectService;
        this.feedBack = feedbackPanel;
        this.page = aThis;
        this.project = compoundPropertyModel.getObject();
        
        feedBack.setVisible(false);
        //field
        add(TextFieldBuilder.<String>createRequired("name", this.project, "name").highlightOnErrors()
                .simpleValidator(0, 255).withTooltip("Project requires a name").build());
        
        add(TextFieldBuilder.<String>createRequired("projectKey", this.project, "projectKey")
                .simpleValidator(0, 255).highlightOnErrors().withTooltip("Project requires a Key").build());
        
        add(TextAreaBuilder.<String>create("description", this.project, "description")
                .simpleValidator(0, 2048).highlightOnErrors().withTooltip("Description can be add").build());
        
        add(TextFieldBuilder.<String>create("idCustomer", this.project, "idCustomer").withTooltip("customer can be affected")
                .build());

        //button
        add(new AjaxLinkLayout<LayoutPage>("cancel", page) {
            
            @Override
            public void onClick(final AjaxRequestTarget art) {
                LayoutPage page = getCustom();
                page.setResponsePage(new ProjectPage(page.getPageParameters()));
            }
        });
        
        add(new AjaxButton("submit", this) {
            
            @Override
            protected void onError(final AjaxRequestTarget target, final Form<?> form) {
                
                feedBack.setVisible(true);
                error("error found");
                // repaint the feedback panel so errors are shown
                target.add(feedBack);
            }
            
            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
                
                feedBack.setVisible(false);
                info("Submitted information");
                // repaint the feedback panel so that it is hidden
                target.add(feedBack);
                
            }
        });
        
    }
    
    @Override
    protected void onSubmit() {
        final Project projectInsert = new Project();
        projectInsert.setId(this.project.getId());
        projectInsert.setIdCustomer(this.project.getIdCustomer());
        projectInsert.setDescription(this.project.getDescription());
        projectInsert.setName(this.project.getName());
        projectInsert.setProjectKey(this.project.getProjectKey());
        if (projectInsert.getId() != null) {
            this.prService.updateByPrimaryKey(projectInsert);
        } else {
            this.prService.insert(projectInsert);
        }
        page.setResponsePage(new ProjectPage(page.getPageParameters()));
    }
}