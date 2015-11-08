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

public class CoordinateTest {

	private CartesianCoordinate cc1, cc2, cc3, cc4, cc5;
	private SphericCoordinate sc1, sc2, sc3, sc4, sc5;
	private double epsilon = 0.00001;

	@Before
	public void setUp() {
		cc1 = new CartesianCoordinate(0, 0,0);
		cc2 = new CartesianCoordinate(2, 2, 2);
		cc3 = new CartesianCoordinate(-2, 2,2);
		cc4 = new CartesianCoordinate(2, -2, 2);
		cc5 = new CartesianCoordinate(2, 2,-2);
		
		sc1 = new SphericCoordinate(0, 0,0);
		sc2 = new SphericCoordinate(2, 2, 2);
		sc3 = new SphericCoordinate(-2, 2,2);
		sc4 = new SphericCoordinate(2, -2, 2);
		sc5 = new SphericCoordinate(2, 2,-2);
	}


	@Test
	public void testCartesianCoordinateDistance() {
		
		assertEquals(0.0, cc1.getDistance(cc1), epsilon);
		assertEquals(0.0, cc2.getDistance(cc2), epsilon);
		assertEquals(0.0, cc3.getDistance(cc3), epsilon);
		assertEquals(0.0, cc4.getDistance(cc4), epsilon);
		assertEquals(0.0, cc5.getDistance(cc5), epsilon);		
		
		assertEquals(3.46410, cc1.getDistance(cc2), epsilon);
		assertEquals(4.0,  	  cc2.getDistance(cc3), epsilon);
		assertEquals(5.65685, cc3.getDistance(cc4), epsilon);
		assertEquals(5.65685, cc4.getDistance(cc5), epsilon);
		assertEquals(3.46410, cc5.getDistance(cc1), epsilon);
	}
	
	@Test
	public void testSphericCoordinateDistance() {
		
		assertEquals(0.0, sc1.getDistance(sc1), epsilon);
		assertEquals(0.0, sc2.getDistance(sc2), epsilon);
		assertEquals(0.0, sc3.getDistance(sc3), epsilon);
		assertEquals(0.0, sc4.getDistance(sc4), epsilon);
		assertEquals(0.0, sc5.getDistance(sc5), epsilon);
		
		assertEquals(2.0, sc1.getDistance(sc2), epsilon);
		assertEquals(0.13959, sc2.getDistance(sc3), epsilon);
		assertEquals(0.19736, sc3.getDistance(sc4), epsilon);
		assertEquals(3.99756, sc4.getDistance(sc5), epsilon);
		assertEquals(2.0, sc5.getDistance(sc1), epsilon);
	}
	
	@Test
	public void testSphericAndCartesianCoordinateDistance() {		
		assertEquals(2.0, cc1.getDistance(sc2), epsilon);
		assertEquals(2.83017, cc2.getDistance(sc3), epsilon);
		assertEquals(4.89796, cc3.getDistance(sc4), epsilon);
		assertEquals(4.89800, cc4.getDistance(sc5), epsilon);
		assertEquals(3.46410, cc5.getDistance(sc1), epsilon);
	}

	@Test(expected = NullPointerException.class)
	public void testSecondCartesianCoordinateGetDistanceNullShouldCauseException() {
		cc1.getDistance(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testSecondSphericCoordinateGetDistanceNullShouldCauseException() {
		sc1.getDistance(null);
	}
	
	
	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToHighShouldCauseException() {
		sc1 = new SphericCoordinate(91, 0);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLatitudinalCoordinateToLowShouldCauseException() {
		sc1 = new SphericCoordinate(-91, 0);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToHighShouldCauseException() {
		sc1 = new SphericCoordinate(0, 181);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLongitudinalCoordinateToLowShouldCauseException() {
		sc1 = new SphericCoordinate(0, -181);
	}


}
