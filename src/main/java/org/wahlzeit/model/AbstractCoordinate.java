/*
 * Copyright (c) Richard Fuchs
 *
 * This file is part of the Wahlzeit photo rating application.
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

public abstract class AbstractCoordinate implements Coordinate {

	/**
	* Calculates the distance between the coordinate and a second coordinate
	* @param c the second coordinate to calculate the distance from
	* @return the distance in kilometer between the coordinates
	* @methodtype query
	* @methodproperty composed
	*/
	public double getDistance (Coordinate c){
	//Pythagoras:
		assertCordinateNull(c);
		return Math.sqrt(
				Math.pow(c.getX() - this.getX(), 2) 
				+ Math.pow(c.getY() - this.getY(), 2) 
				+ Math.pow(c.getZ() - this.getZ(), 2));
	}

	@Override
	public boolean isEqual(Coordinate c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getZ() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * @methodtype assert
	 */
	private void assertCordinateNull(Coordinate c) {
		if (c == null) {
			throw new NullPointerException("coordinate must not be null");
		}
	}

}
