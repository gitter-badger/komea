
package org.komea.product.wicket;



import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;



public abstract class LayoutPage extends WebPage
{
    
    
    public LayoutPage(final PageParameters _parameters) {
    
    
        super(_parameters);
        add(new Label("page_title", Model.of(getTitle())));
        
    }
    
    
    public abstract String getTitle();
    
    
}