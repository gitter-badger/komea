package org.komea.core.model.integration.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.komea.core.model.impl.OEntityAttributeManager;
import org.komea.core.schema.IKomeaSchemaFactory;
import org.komea.core.schema.IReference;
import org.komea.core.schema.Primitive;
import org.komea.core.schema.ReferenceArity;
import org.komea.core.schema.impl.KomeaSchemaFactory;
import org.komea.orientdb.session.impl.DatabaseConfiguration;
import org.komea.orientdb.session.impl.OrientGraphDatabaseFactory;
import org.komea.orientdb.session.impl.TestDatabaseConfiguration;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;

public class OAttributeManagerTests {
	private OrientVertex vertex;
	private final IKomeaSchemaFactory sfactory = new KomeaSchemaFactory();
	private OrientGraph graph;
	private OrientGraphDatabaseFactory sessionsFactory;

	@After
	public void end() throws IOException {
		this.sessionsFactory.getGraph().drop();
		this.sessionsFactory.close();
	}

	@Before
	public void init() {
		this.sessionsFactory = new OrientGraphDatabaseFactory();
		final DatabaseConfiguration databaseConfiguration = new TestDatabaseConfiguration();
		this.sessionsFactory.init(databaseConfiguration);
		this.graph = this.sessionsFactory.getGraph();
		this.vertex = this.graph.addVertex(null);

	}

	@Test
	public void setPrimitiveCollectionReferenceTest() {
		final IReference name = this.sfactory.newAttribute("values",
				Primitive.INTEGER).setArity(ReferenceArity.MANY);
		final OEntityAttributeManager updater = new OEntityAttributeManager(
				this.vertex, name);
		updater.addReference(1);
		updater.addReference(2);
		final List<Integer> values = updater.get();
		assertEquals(values.size(), 2);
	}

	@Test
	public void setPrimitiveCollectionValidationReferenceTest() {
		final IReference name = this.sfactory.newAttribute("values",
				Primitive.INTEGER).setArity(ReferenceArity.MANY);
		final OEntityAttributeManager updater = new OEntityAttributeManager(
				this.vertex, name);

		try {
			updater.addReference("a");
			// we can not add a String in an integer collection attribute
			fail();
		} catch (final IllegalArgumentException e) {
			// succeed
		}
	}

	@Test
	public void setPrimitiveReferenceTest() {
		final IReference name = this.sfactory.newAttribute("name",
				Primitive.STRING);
		final OEntityAttributeManager updater = new OEntityAttributeManager(
				this.vertex, name);
		updater.set("John Doe");
		final String value = updater.get();
		assertEquals("John Doe", value);
	}

	@Test
	public void setPrimitiveValidationReferenceTest() {
		final IReference name = this.sfactory.newAttribute("name",
				Primitive.STRING);
		final OEntityAttributeManager updater = new OEntityAttributeManager(
				this.vertex, name);

		try {
			updater.set(1);
			// we can not set an integer in a string attribute
			fail();
		} catch (final IllegalArgumentException e) {
			// succeed
		}
	}

}