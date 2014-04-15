/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.komea.product.plugins.testlink.userinterface;



import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.komea.product.plugins.testlink.api.ITestLinkServerDAO;
import org.komea.product.plugins.testlink.model.TestLinkServer;
import org.komea.product.wicket.LayoutPage;
import org.komea.product.wicket.widget.builders.AjaxLinkLayout;
import org.komea.product.wicket.widget.builders.TextFieldBuilder;



/**
 * @author rgalerme
 */
public class TestLinkForm extends Form<TestLinkServer>
{
    
    
    private final Component          feedBack;
    private final String             oldAdress;
    private final LayoutPage         page;
    private final ITestLinkServerDAO testlinkService;
    private final TestLinkServer     testServer;
    
    
    
    public TestLinkForm(
            final LayoutPage _page,
            final TestLinkServer _testServer,
            final ITestLinkServerDAO _testlinkService,
            final Component _feedBack,
            final String id,
            final IModel<TestLinkServer> model) {
    
    
        super(id, model);
        page = _page;
        testServer = _testServer;
        testlinkService = _testlinkService;
        feedBack = _feedBack;
        oldAdress = testServer.getAddress();
        
        feedBack.setVisible(false);
        
        add(TextFieldBuilder.<String> createRequired("name", testServer, "name")
                .withTooltip("Server requires a name").simpleValidator(3, 255).build());
        add(TextFieldBuilder.<String> createRequired("address", testServer, "address")
                .simpleValidator(4, 255).withTooltip("Server requires an url").build());
        add(TextFieldBuilder
                .<String> createRequired("key", testServer, "key")
                .simpleValidator(1, 255)
                .withTooltip(
                        "Server requires a key for connexion, generates it from your testlink profile.")
                .build());
        
        // button
        add(new AjaxLinkLayout<LayoutPage>("cancel", page)
        {
            
            
            @Override
            public void onClick(final AjaxRequestTarget art) {
            
            
                final LayoutPage page = getCustom();
                page.setResponsePage(new TestLinkPage(page.getPageParameters()));
            }
        });
        
        add(new AjaxButton("submit", this)
        {
            
            
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
                testlinkService.saveOrUpdate(testServer);
                page.setResponsePage(new TestLinkPage(page.getPageParameters()));
                
            }
        });
    }
    
}
