/*
 * generated by Xtext
 */
package org.komea.events.dsl.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractEventDslValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.komea.events.dsl.eventDsl.EventDslPackage.eINSTANCE);
		return result;
	}
}