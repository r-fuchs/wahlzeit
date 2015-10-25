package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

	private Coordinate c1, c2, c3, c4, c5;
	private double epsilon = 0.001;

	@Before
	public void setUp() {
		c1 = new Coordinate(0, 0);
		c2 = new Coordinate(2, 2);
		c3 = new Coordinate(0, -2);
		c4 = new Coordinate(-2, 0);
		c5 = new Coordinate(-2, -2);
	}

	/**
	 *
	 */
	@Test
	public void testLatidudinalDistance() {
		assertEquals(0.0, c1.getDistance(c1).getLatidtude(), epsilon);
		assertEquals(0.0, c2.getDistance(c2).getLatidtude(), epsilon);
		assertEquals(0.0, c3.getDistance(c3).getLatidtude(), epsilon);
		assertEquals(0.0, c4.getDistance(c4).getLatidtude(), epsilon);
		assertEquals(0.0, c5.getDistance(c5).getLatidtude(), epsilon);

		assertEquals(2.0, c1.getDistance(c2).getLatidtude(), epsilon);
		assertEquals(2.0, c2.getDistance(c3).getLatidtude(), epsilon);
		assertEquals(2.0, c3.getDistance(c4).getLatidtude(), epsilon);
		assertEquals(0.0, c4.getDistance(c5).getLatidtude(), epsilon);
		assertEquals(2.0, c5.getDistance(c1).getLatidtude(), epsilon);
	}

	/**
	 *
	 */
	@Test
	public void testLongitudinalDistance() {
		assertEquals(0.0, c1.getDistance(c1).getLongitude(), epsilon);
		assertEquals(0.0, c2.getDistance(c2).getLongitude(), epsilon);
		assertEquals(0.0, c3.getDistance(c3).getLongitude(), epsilon);
		assertEquals(0.0, c4.getDistance(c4).getLongitude(), epsilon);
		assertEquals(0.0, c5.getDistance(c5).getLongitude(), epsilon);

		assertEquals(2.0, c1.getDistance(c2).getLongitude(), epsilon);
		assertEquals(4.0, c2.getDistance(c3).getLongitude(), epsilon);
		assertEquals(2.0, c3.getDistance(c4).getLongitude(), epsilon);
		assertEquals(2.0, c4.getDistance(c5).getLongitude(), epsilon);
		assertEquals(2.0, c5.getDistance(c1).getLongitude(), epsilon);
	}

	/**
	 * Test the bounds of the Coordinates: 
	 * latitude can be between - 90 and 90
	 * longitude can be between - 180 and 180
	 */
	public void testCoordinateValuesBounds() {
		c1 = new Coordinate(90, 0);
		c1 = new Coordinate(-90, 0);
		c1 = new Coordinate(0, 180);
		c1 = new Coordinate(0, -180);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToHighShouldCauseException() {
		c1 = new Coordinate(91, 0);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToLowShouldCauseException() {
		c1 = new Coordinate(-91, 0);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToHighShouldCauseException() {
		c1 = new Coordinate(0, 181);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToLowShouldCauseException() {
		c1 = new Coordinate(0, -181);
	}

	/**
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void testLatitudinalDistanceNullShouldCauseException() {
		c1.getLatitudinalDistance(null);
	}

	/**
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void testLongitudinalDistanceNullShouldCauseException() {
		c1.getLongitudinalDistance(null);
	}

}
