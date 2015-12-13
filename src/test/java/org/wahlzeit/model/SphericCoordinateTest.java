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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the SphericCoordinate Class
 */
public class SphericCoordinateTest {

	private Coordinate sc1, sc2, sc3, sc4, s1, s2, s3;
	private double epsilon = 0.0001;

	@Before
	public void setUp() {
		sc1 = SphericCoordinate.getInstance(0, 0, 0);
		sc2 = SphericCoordinate.getInstance(2, 2, 2);
		sc3 = SphericCoordinate.getInstance(-2, 2, 2);
		sc4 = SphericCoordinate.getInstance(2, -2, 2);
		s1  = SphericCoordinate.getInstance(42.0, 0.0, 0.0);
		s2  = SphericCoordinate.getInstance(1.0, 1.0, 1.0);
		s3  = SphericCoordinate.getInstance(1.0, 1.0, 1.0);
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
	
	@Test
	public void testShared() {
		assertFalse(s1.isEqual(s3));
		assertFalse(s1 == s3);
		assertFalse(s2.isEqual(s1));
		assertFalse(s2 == s1);
		assertTrue(s2.isEqual(s3));
		assertTrue(s2 == s3);
		assertTrue(s3.isEqual(s2));
		assertTrue(s3 == s2);
	}
	
	@Test
	public void testImmutable() {
		SphericCoordinate t1 = (SphericCoordinate) SphericCoordinate.getInstance(1, 1, 1);
		SphericCoordinate t2 = t1.setLatitude(2);	
		assertFalse(t1.isEqual(t2));
	}
	
	@Test(expected = NullPointerException.class)
	public void testSecondCoordinateGetDistanceNullShouldCauseException() {
		sc1.getDistance(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToHighShouldCauseException() {
		sc1 = SphericCoordinate.getInstance(91, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToLowShouldCauseException() {
		sc1 = SphericCoordinate.getInstance(-91, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToHighShouldCauseException() {
		sc1 = SphericCoordinate.getInstance(0, 181);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToLowShouldCauseException() {
		sc1 = SphericCoordinate.getInstance(0, -181);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRadiusSmallerThanZeroShouldCauseException() {
		sc1 = SphericCoordinate.getInstance(0, 0, -1);
	}

}
