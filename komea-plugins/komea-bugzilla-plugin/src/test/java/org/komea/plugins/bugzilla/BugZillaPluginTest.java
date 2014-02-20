/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.komea.plugins.bugzilla;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.komea.backend.plugins.bugzilla.BugZillaAlertFactory;
import org.komea.backend.plugins.bugzilla.BugZillaCheckerBean;
import org.komea.backend.plugins.bugzilla.BugZillaConfiguration;
import org.komea.backend.plugins.bugzilla.BugZillaConfigurationService;
import org.komea.backend.plugins.bugzilla.BugZillaContext;
import org.komea.backend.plugins.bugzilla.BugZillaServer;
import org.komea.backend.plugins.bugzilla.BugzillaBug;
import org.komea.backend.plugins.bugzilla.api.IBugZillaAlertFactory;
import org.komea.backend.plugins.bugzilla.api.IBugZillaConfigurationService;
import org.komea.backend.plugins.bugzilla.api.IBugZillaServerProxy;
import org.komea.backend.plugins.bugzilla.api.IBugZillaServerProxyFactory;
import org.komea.product.backend.service.esper.IEventPushService;
import org.komea.product.backend.service.fs.IObjectStorage;
import org.komea.product.backend.service.plugins.IPluginStorageService;
import org.komea.product.database.dto.EventSimpleDto;
import org.komea.product.test.spring.AbstractSpringIntegrationTestCase;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

/**
 * @author rgalerme
 */
// @RunWith(SpringJUnit4ClassRunner.class)
public class BugZillaPluginTest extends AbstractSpringIntegrationTestCase {
    
    // @Mock
    // private IBugZillaConfigurationService conf;
    @Test
    public void testPluginWithoutBugZilla() {
    
        System.out.println("Debut du test");
        // Mockito.when(conf.getServers()).then(new Answer<List<I>)
        final BugZillaCheckerBean bbean = new BugZillaCheckerBean();
        // bbean.setAlertFactory(Mockito.mock(IBugZillaAlertFactory.class));
        
        final IBugZillaAlertFactory alertFactory = new BugZillaAlertFactory();
        bbean.setAlertFactory(alertFactory);
        final IEventPushService mockAlertService = Mockito.mock(IEventPushService.class);
        final ArgumentCaptor<EventSimpleDto> forClass = ArgumentCaptor.forClass(EventSimpleDto.class);
        bbean.setAlertService(mockAlertService);
        
        final IBugZillaConfigurationService bugZillaConfiguration = new BugZillaConfigurationService();
        final IPluginStorageService plService = Mockito.mock(IPluginStorageService.class);
        bugZillaConfiguration.setPluginStorage(plService);
        
        // mock du server bugzilla
        final IBugZillaServerProxyFactory bzfact = Mockito.mock(IBugZillaServerProxyFactory.class);
        final IBugZillaServerProxy j2connector = Mockito.mock(IBugZillaServerProxy.class);
        
        final List<String> listProjet = new ArrayList<String>();
        listProjet.add("Makeb");
        listProjet.add("Cornelia");
        
        Mockito.when(j2connector.getListProjects()).thenReturn(listProjet);
        
        final List<BugzillaBug> listMakeb = new ArrayList<BugzillaBug>();
        Date d = new Date();
        Date d1 = new Date();
        Date d2 = new Date();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            
            d = simpleDateFormat.parse("15/10/2013");
            d1 = simpleDateFormat.parse("15/12/2013");
            d2 = simpleDateFormat.parse("01/01/2014");
        } catch (final ParseException ex) {
            Logger.getLogger(BugZillaPluginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listMakeb.add(new BugzillaBug(1, "NEW", true, d, true)); // id , status, ouvert, date creation , assigne
        listMakeb.add(new BugzillaBug(2, "CONFIRMED", true, d, false));
        listMakeb.add(new BugzillaBug(3, "UNCONFIRMED", true, d2, false));
        listMakeb.add(new BugzillaBug(4, "REOPENED", true, d2, false));
        listMakeb.add(new BugzillaBug(5, "RESOLVED", false, d1, true));
        listMakeb.add(new BugzillaBug(6, "VERIFIED", false, d1, true));
        
        final List<BugzillaBug> listCornelia = new ArrayList<BugzillaBug>();
        listCornelia.add(new BugzillaBug(7, "REOPENED", false, d2, false));
        
        Mockito.when(j2connector.getListBugs("Makeb")).thenReturn(listMakeb);
        Mockito.when(j2connector.getListBugs("Cornelia")).thenReturn(listCornelia);
        
        // ///////////////////////////////////////////
        bugZillaConfiguration.setServerProxyFactory(bzfact);
        
        final IObjectStorage<BugZillaConfiguration> storage = Mockito.mock(IObjectStorage.class);
        final BugZillaConfiguration bconf = Mockito.mock(BugZillaConfiguration.class);
        final BugZillaServer idServer = Mockito.mock(BugZillaServer.class);
        
        final BugZillaContext bc = new BugZillaContext();
        Mockito.when(idServer.getAddress()).thenReturn("http://192.168.1.88/bugzilla/");
        Mockito.when(idServer.getLogin()).thenReturn("raphael.galerme@tocea.com");
        Mockito.when(idServer.getMdp()).thenReturn("rgalerme");
        Mockito.when(idServer.getContext()).thenReturn(bc);
        
        final List<BugZillaServer> listBServ = new ArrayList<BugZillaServer>();
        listBServ.add(idServer);
        
        Mockito.when(bconf.getConfigurations()).thenReturn(listBServ);
        Mockito.when(storage.get()).thenReturn(bconf);
        Mockito.when(plService.registerStorage("BUGZILLA", BugZillaConfiguration.class)).thenReturn(storage);
        
        ((BugZillaConfigurationService) bugZillaConfiguration).init();
        
        bbean.setBugZillaConfiguration(bugZillaConfiguration);
        Mockito.when(bzfact.newConnector(idServer)).thenReturn(j2connector);
        
        bbean.checkServers();
        Mockito.verify(mockAlertService, Mockito.times(17)).sendEventDto(forClass.capture());
        System.out.println("forClass" + forClass.getAllValues());
        bbean.checkServers();
        Mockito.verify(mockAlertService, Mockito.times(34)).sendEventDto(forClass.capture());
        System.out.println("Fin du test");
        
    }
    
    /*
     * @Test
     * public void testPluginWithBugZilla() {
     * System.out.println("Debut du test");
     * // Mockito.when(conf.getServers()).then(new Answer<List<I>)
     * final BugZillaCheckerBean bbean = new BugZillaCheckerBean();
     * // bbean.setAlertFactory(Mockito.mock(IBugZillaAlertFactory.class));
     * //mock du server bugzilla
     * /////////////////////////////////////////////
     * IBugZillaAlertFactory alertFactory = new BugZillaAlertFactory();
     * bbean.setAlertFactory(alertFactory);
     * IAlertService mockAlertService = Mockito.mock(IAlertService.class);
     * ArgumentCaptor<IEvent> forClass = ArgumentCaptor.forClass(IEvent.class);
     * bbean.setAlertService(mockAlertService);
     * IBugZillaConfigurationService bugZillaConfiguration = new BugZillaConfigurationService();
     * IPluginStorageService plService = Mockito.mock(IPluginStorageService.class);
     * bugZillaConfiguration.setPluginStorage(plService);
     * IBugZillaServerProxyFactory fac = new BugZillaServerProxyFactory();
     * bugZillaConfiguration.setServerProxyFactory(fac);
     * IObjectStorage<BugZillaConfiguration> storage = Mockito.mock(IObjectStorage.class);
     * BugZillaConfiguration bconf = Mockito.mock(BugZillaConfiguration.class);
     * BugZillaServer idServer = Mockito.mock(BugZillaServer.class);
     * BugZillaContext bc = new BugZillaContext();
     * Mockito.when(idServer.getAddress()).thenReturn("http://192.168.1.88/bugzilla/");
     * Mockito.when(idServer.getLogin()).thenReturn("raphael.galerme@tocea.com");
     * Mockito.when(idServer.getMdp()).thenReturn("rgalerme");
     * Mockito.when(idServer.getContext()).thenReturn(bc);
     * List<BugZillaServer> listBServ = new ArrayList<BugZillaServer>();
     * listBServ.add(idServer);
     * Mockito.when(bconf.getConfigurations()).thenReturn(listBServ);
     * Mockito.when(storage.get()).thenReturn(bconf);
     * Mockito.when(plService.registerStorage("BUGZILLA", BugZillaConfiguration.class)).thenReturn(storage);
     * ((BugZillaConfigurationService) bugZillaConfiguration).init();
     * bbean.setBugZillaConfiguration(bugZillaConfiguration);
     * bbean.checkServers();
     * Mockito.verify(mockAlertService, Mockito.times(13)).sendEvent(forClass.capture());
     * System.out.println("forClass" + forClass.getAllValues());
     * bbean.checkServers();
     * System.out.println("Fin du test");
     * }
     */
}
