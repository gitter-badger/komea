
package org.komea.product.wicket.providers;



import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.komea.product.database.dao.ProviderDao;
import org.komea.product.wicket.LayoutPage;



/**
 * Person admin page
 * 
 * @author sleroy
 */
public class ProviderPage extends LayoutPage
{
    
    
    @SpringBean
    private ProviderDao providerDAO;
    
    
    
    public ProviderPage(final PageParameters _parameters) {
    
    
        super(_parameters);
        
        
    }
    
    
}
