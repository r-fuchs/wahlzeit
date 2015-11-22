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
* Test the SphericCoordinate and the CartesianCoordinate Class
*/
public class CoordinateTest {

	private Coordinate cc1, cc2, cc3, cc4, cc5;
	private Coordinate sc1, sc2, sc3, sc4, sc5;
	private double epsilon = 0.00001;

	@Before
	public void setUp() {
		cc1 = new CartesianCoordinate(0, 0,0);
		cc2 = new CartesianCoordinate(2, 2, 2);
		cc3 = new CartesianCoordinate(-2, 2,2);
		cc4 = new CartesianCoordinate(2, -2, 2);
		
		sc1 = new SphericCoordinate(0, 0,0);
		sc2 = new SphericCoordinate(2, 2, 2);
		sc3 = new SphericCoordinate(-2, 2,2);
		sc4 = new SphericCoordinate(2, -2, 2);
	}
	
	@Test
	public void testSphericAndCartesianCoordinateDistance() {
		assertEquals(sc2.getDistance(cc1), cc1.getDistance(sc2), epsilon);
		assertEquals(sc3.getDistance(cc2), cc2.getDistance(sc3), epsilon);
		assertEquals(sc4.getDistance(cc3), cc3.getDistance(sc4), epsilon);

		assertEquals(2.0, 		cc1.getDistance(sc2), epsilon);
		assertEquals(2.83017, 	cc2.getDistance(sc3), epsilon);
		assertEquals(4.89796, 	cc3.getDistance(sc4), epsilon);
	}
}
