package org.komea.connectors.bugzilla

import static org.junit.Assert.*

import org.junit.Test
import org.komea.connectors.bugzilla.events.IBugzillaConnectorInformations;
import org.komea.connectors.bugzilla.events.impl.BugzillaEventConnector;
import org.komea.connectors.bugzilla.proxy.impl.BugzillaServerConfiguration;
import org.komea.event.query.service.EventQueryManagerService
import org.komea.event.storage.service.EventStorageService
import org.komea.orientdb.session.impl.OrientDocumentDatabaseFactory
import org.komea.orientdb.session.impl.TestDatabaseConfiguration

import spock.lang.Specification

class BugzillaDataConnectorIT extends Specification {

	@Test
	public void test() {
		setup:
		def bzServerConfiguration = new BugzillaServerConfiguration()
		bzServerConfiguration.serverURL = 'https://issues.apache.org/bugzilla/'
		bzServerConfiguration.project= 'POI'

		def dbc = new TestDatabaseConfiguration()
		// ORIENTDB
		def ogf = new OrientDocumentDatabaseFactory(dbc)
		def eventStorage = new EventStorageService(ogf)
		def queryservice = new EventQueryManagerService(ogf)


		when: "I inject the history of bugzilla  of Apache POI"
		def dataConnector = new BugzillaEventConnector(eventStorage, bzServerConfiguration)
		dataConnector.launch()
		// "I query Komea for the number of new bugs and updated bugs"
		def newBugs = queryservice.countEventsOfType(IBugzillaConnectorInformations.EVENT_NEW_BUG)
		println "Number of new bugs found ${newBugs}"
		def updatedBugs = queryservice.countEventsOfType(IBugzillaConnectorInformations.EVENT_UPDATED_BUG)
		println "Number of update bugs found ${updatedBugs}"

		then: "I obtain positive values (bug created, bug updated)"
		newBugs > 0
		updatedBugs > 0

	}
}