package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppleTest {

	Apple bigApple, smallApple;
	AppleType bigAppleType, smallAppleType;
	AppleManager am = AppleManager.getInstance();

	@Before
	public void setUp() {
		bigAppleType = am.createAppleType("bigApple", 50, 40, "bigApple");
		smallAppleType = am.createAppleType("smallApple", 10, 5, "smallApple");
		bigApple = am.createApple("bigApple");
		smallApple = am.createApple("smallApple");
	}

	@Test
	public void testAppleTypeCreation() {
		assertEquals(bigApple.getType(), bigAppleType);
		assertEquals(bigAppleType.getName(), "bigApple");
		assertTrue(bigAppleType.getSize() == 50);
		assertTrue(bigAppleType.getWeight() == 40);
	}

	@Test
	public void testAppleCreation() {
		am.createAppleType("bigApple2", 50, 40, "bigApple2");
		Apple a2 = am.createApple("bigApple2");
		assertFalse(bigApple.getId() == a2.getId());
		assertTrue(a2.getType().getName().equals("bigApple2"));
		assertTrue(a2.getType().getSize() == 50);
		assertTrue(a2.getType().getWeight() == 40);
	}

	@Test
	public void testAppleGetType() {
		AppleType bigAppleT = am.getAppleType("bigApple");
		assertTrue(bigAppleT.getName().equals("bigApple"));
		assertTrue(bigAppleT.getSize() == 50);
		assertTrue(bigAppleT.getWeight() == 40);
	}

	@Test
	public void testAppleSuperTypes() {
		AppleType bigAppleSubType = am.createAppleType("bigRedApple", 50, 40, "bigRedApple");
		bigAppleType.addSubType(bigAppleSubType);
		assertTrue(bigAppleSubType.getSuperType().equals(bigAppleType));
	}

	@Test
	public void testAppleSubTypes() {
		AppleType bigAppleSubType = am.createAppleType("bigRedApple", 50, 40, "bigRedApple");
		bigAppleType.addSubType(bigAppleSubType);
		assertTrue(bigAppleType.getSubTypesIterator().next().equals(bigAppleSubType));
	}

}
