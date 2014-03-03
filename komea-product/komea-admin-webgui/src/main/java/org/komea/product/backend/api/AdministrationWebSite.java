/**
 * 
 */

package org.komea.product.backend.api;



import org.komea.product.wicket.LoginPage;
import org.komea.product.wicket.UnauthorizedPage;
import org.komea.product.wicket.console.ConsolePage;
import org.komea.product.wicket.cronpage.CronPage;
import org.komea.product.wicket.events.EventsPage;
import org.komea.product.wicket.kpis.KpiEditPage;
import org.komea.product.wicket.kpis.KpiPage;
import org.komea.product.wicket.person.PersonAddPage;
import org.komea.product.wicket.person.PersonPage;
import org.komea.product.wicket.project.ProjectEditPage;
import org.komea.product.wicket.project.ProjectPage;
import org.komea.product.wicket.providers.ProviderPage;
import org.komea.product.wicket.settings.SettingsPage;
import org.komea.product.wicket.statistics.StatPage;



/**
 * This class defines the web pages of the administration web site
 * 
 * @author sleroy
 */
@MountAdminPages({
        @MountPage(mount = "/kpis", page = KpiPage.class),
        @MountPage(mount = "/kpiedit", page = KpiEditPage.class),
        @MountPage(mount = "/projectedit", page = ProjectEditPage.class),
        @MountPage(mount = "/projects", page = ProjectPage.class),
        @MountPage(mount = "/settings", page = SettingsPage.class),
        @MountPage(mount = "/viewlog", page = ConsolePage.class),
        @MountPage(mount = "/stats", page = StatPage.class),
        @MountPage(mount = "/login", page = LoginPage.class),
        @MountPage(mount = "/cronpage", page = CronPage.class),
        @MountPage(mount = "/logout", page = LoginPage.class),
        @MountPage(mount = "/accessdenied", page = UnauthorizedPage.class),
        @MountPage(mount = "/users", page = PersonPage.class),
        @MountPage(mount = "/useradd", page = PersonAddPage.class),
        @MountPage(mount = "/events", page = EventsPage.class),
        @MountPage(mount = "/plugins", page = ProviderPage.class) })
public class AdministrationWebSite
{
    //
}