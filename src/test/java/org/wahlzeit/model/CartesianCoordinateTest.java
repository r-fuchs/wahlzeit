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
* Test the CartesianCoordinate Class
*/
public class CartesianCoordinateTest {

	private Coordinate cc1, cc2, cc3, cc4, cc5;
	private double epsilon = 0.00001;

	@Before
	public void setUp() {
		cc1 = CartesianCoordinate.getInstance(0, 0,0);
		cc2 = CartesianCoordinate.getInstance(2, 2, 2);
		cc3 = CartesianCoordinate.getInstance(-2, 2,2);
		cc4 = CartesianCoordinate.getInstance(2, -2, 2);
		cc5 = CartesianCoordinate.getInstance(2, 2,-2);
	}

	@Test
	public void testCoordinateDistance() {
		assertEquals(cc2.getDistance(cc1), cc1.getDistance(cc2), epsilon);
		assertEquals(cc3.getDistance(cc2), cc2.getDistance(cc3), epsilon);
		assertEquals(cc4.getDistance(cc3), cc3.getDistance(cc4), epsilon);
		assertEquals(cc5.getDistance(cc4), cc4.getDistance(cc5), epsilon);
		assertEquals(cc1.getDistance(cc5), cc5.getDistance(cc1), epsilon);
		
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
	
	@Test(expected = NullPointerException.class)
	public void testSecondCartesianCoordinateGetDistanceNullShouldCauseException() {
		cc1.getDistance(null);
	}
}
