
package org.komea.product.wicket;



import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IExceptionSettings;
import org.apache.wicket.settings.IExceptionSettings.ThreadDumpStrategy;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.komea.product.wicket.console.ConsolePage;
import org.komea.product.wicket.cronpage.CronPage;
import org.komea.product.wicket.person.PersonPage;
import org.komea.product.wicket.settings.SettingsPage;
import org.komea.product.wicket.statistics.StatPage;



/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
    
    
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
    
    
        return HomePage.class;
    }
    
    
    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
    
    
        super.init();
        
        
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        // don't throw exceptions for missing translations
        getResourceSettings().setThrowExceptionOnMissingResource(false);
        
        // enable ajax debug etc.
        getDebugSettings().setDevelopmentUtilitiesEnabled(true);
        // getDebugSettings().setComponentUseCheck(false);
        // make markup friendly as in deployment-mode
        getMarkupSettings().setStripWicketTags(true);
        // page mounts / SEO
        mountPage("/home", HomePage.class);
        mountPage("/settings", SettingsPage.class);
        mountPage("/viewlog", ConsolePage.class);
        mountPage("/stats", StatPage.class);
        mountPage("/login", LoginPage.class);
        mountPage("/cronpage", CronPage.class);
        mountPage("/logout", LoginPage.class);
        mountPage("/accessdenied", UnauthorizedPage.class);
        mountPage("/users", PersonPage.class);
        getExceptionSettings().setThreadDumpStrategy(ThreadDumpStrategy.ALL_THREADS);
        getExceptionSettings()
                .setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_EXCEPTION_PAGE);
    }
}