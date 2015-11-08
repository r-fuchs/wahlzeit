package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Coordinate class.
 */
public class SphericCoordinateTest {

	private Coordinate c1, c2, c3, c4, c5;
	private double epsilon = 0.001;

	@Before
	public void setUp() {
		c1 = new SphericCoordinate(0, 0);
		c2 = new SphericCoordinate(2, 2);
		c3 = new SphericCoordinate(0, -2);
		c4 = new SphericCoordinate(-2, 0);
		c5 = new SphericCoordinate(-2, -2);
	}

	/**
	 *
	 */
	@Test
	public void testDistance() {
		
		assertEquals(0.0, c1.getDistance(c1), epsilon);
		assertEquals(0.0, c2.getDistance(c2), epsilon);
		assertEquals(0.0, c3.getDistance(c3), epsilon);
		assertEquals(0.0, c4.getDistance(c4), epsilon);
		assertEquals(0.0, c5.getDistance(c5), epsilon);

		assertEquals(314.474, c1.getDistance(c2), epsilon);
		assertEquals(497.198, c2.getDistance(c3), epsilon);
		assertEquals(314.474, c3.getDistance(c4), epsilon);
		assertEquals(222.254, c4.getDistance(c5), epsilon);
		assertEquals(314.474, c5.getDistance(c1), epsilon);
	}

	/**
	 * Test the bounds of the Coordinates: 
	 * latitude can be between - 90 and 90
	 * longitude can be between - 180 and 180
	 */
	public void testCoordinateValuesBounds() {
		c1 = new SphericCoordinate(90, 0);
		c1 = new SphericCoordinate(-90, 0);
		c1 = new SphericCoordinate(0, 180);
		c1 = new SphericCoordinate(0, -180);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToHighShouldCauseException() {
		c1 = new SphericCoordinate(91, 0);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToLowShouldCauseException() {
		c1 = new SphericCoordinate(-91, 0);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToHighShouldCauseException() {
		c1 = new SphericCoordinate(0, 181);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToLowShouldCauseException() {
		c1 = new SphericCoordinate(0, -181);
	}

}
