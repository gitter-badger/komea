/*
* generated by Xtext
*/
package org.komea.events.dsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EventDslStandaloneSetup extends EventDslStandaloneSetupGenerated{

	public static void doSetup() {
		new EventDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

