package org.komea.connectors.bugzilla;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.komea.software.model.impl.MinimalCompanySchema;

public class BugzillaSchemaBuilderTest {

	@Test
	public void testBugzillaSchema() throws Exception {
		final BugzillaSchemaBuilder bugzillaSchema = new BugzillaSchemaBuilder(new MinimalCompanySchema());
		assertNotNull(bugzillaSchema.getBugzillaPlatform());
		assertNotNull(bugzillaSchema.getBugzillaProduct());
		assertNotNull(bugzillaSchema.getBugzillaProductComponent());
		assertNotNull(bugzillaSchema.getBugzillaProductVersion());

	}
}
