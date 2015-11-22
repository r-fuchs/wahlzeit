/**
 * CoordinateTest
 * 
 * Copyright (c) by Richard Fuchs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the SphericCoordinate Class
 */
public class SphericCoordinateTest {

	private SphericCoordinate sc1, sc2, sc3, sc4;
	private double epsilon = 0.00001;

	@Before
	public void setUp() {
		sc1 = new SphericCoordinate(0, 0, 0);
		sc2 = new SphericCoordinate(2, 2, 2);
		sc3 = new SphericCoordinate(-2, 2, 2);
		sc4 = new SphericCoordinate(2, -2, 2);
	}

	@Test
	public void testCoordinateDistance() {
		assertEquals(sc1.getDistance(sc4), sc4.getDistance(sc1), epsilon);
		assertEquals(sc2.getDistance(sc1), sc1.getDistance(sc2), epsilon);
		assertEquals(sc3.getDistance(sc2), sc2.getDistance(sc3), epsilon);
		assertEquals(sc4.getDistance(sc3), sc3.getDistance(sc4), epsilon);

		assertEquals(0.0, sc1.getDistance(sc1), epsilon);
		assertEquals(0.0, sc2.getDistance(sc2), epsilon);
		assertEquals(0.0, sc3.getDistance(sc3), epsilon);
		assertEquals(0.0, sc4.getDistance(sc4), epsilon);

		assertEquals(2.0, sc1.getDistance(sc2), epsilon);
		assertEquals(0.13959, sc2.getDistance(sc3), epsilon);
		assertEquals(0.19736, sc3.getDistance(sc4), epsilon);
		assertEquals(2.0, sc4.getDistance(sc1), epsilon);
	}

	@Test(expected = NullPointerException.class)
	public void testSecondCoordinateGetDistanceNullShouldCauseException() {
		sc1.getDistance(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToHighShouldCauseException() {
		sc1 = new SphericCoordinate(91, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToLowShouldCauseException() {
		sc1 = new SphericCoordinate(-91, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToHighShouldCauseException() {
		sc1 = new SphericCoordinate(0, 181);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToLowShouldCauseException() {
		sc1 = new SphericCoordinate(0, -181);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRadiusSmallerThanZeroShouldCauseException() {
		sc1 = new SphericCoordinate(0, 0, -1);
	}

}
