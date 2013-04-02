package net.sf.qualitytest.blueprint;

import java.util.ArrayList;
import java.util.List;

import net.sf.qualitytest.CoverageForPrivateConstructor;
import net.sf.qualitytest.StaticCheck;
import net.sf.qualitytest.blueprint.BluePrintTest.Immutable;

import org.junit.Assert;
import org.junit.Test;

public class CollectionBluePrintTest {

	@Test
	public void coverPrivateConstructor() {
		CoverageForPrivateConstructor.giveMeCoverage(CollectionBluePrint.class);
	}

	@Test
	public void testAddMany() {
		final List<Immutable> list = new ArrayList<Immutable>();
		CollectionBluePrint.addMany(list, Immutable.class, 9);
		Assert.assertEquals(9, list.size());
		for (final Immutable immutable : list) {
			Assert.assertNotNull(immutable.getDate());
		}
	}

	@Test
	public void testMakeSureClassIsFinalAndNotAccessible() {
		StaticCheck.classIsFinal(CollectionBluePrint.class);
		StaticCheck.noPublicDefaultConstructor(CollectionBluePrint.class);
	}
}
