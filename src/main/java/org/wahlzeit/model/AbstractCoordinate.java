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

import java.io.Serializable;

/**
 * Abstract implementation of Coordinate Implements basis functions
 */
public abstract class AbstractCoordinate implements Serializable, Coordinate {

	/**
	 * Calculates the distance between the coordinate and a second coordinate
	 * 
	 * @param c
	 *            the second coordinate to calculate the distance from
	 * @return the distance in kilometer between the coordinates
	 * @methodtype query
	 */
	public double getDistance(Coordinate c) {
		assertClassInvariants();
		assertCoordinateNotNull(c);
		double rtnValue = Math.sqrt(Math.pow(c.getX() - this.getX(), 2) + Math.pow(c.getY() - this.getY(), 2)
				+ Math.pow(c.getZ() - this.getZ(), 2));
		assertIsDoubleValue(rtnValue);
		assertIsNotNull(rtnValue);
		assertClassInvariants();
		return rtnValue;
	}

	/**
	 * @methodtype boolean-query
	 */
	public boolean isEqual(Coordinate c) {
		if (this == c)
			return true;
		if (c == null)
			return false;
		if (getClass() != c.getClass())
			return false;
		CartesianCoordinate other = (CartesianCoordinate) c;
		if (Double.doubleToLongBits(getX()) != Double.doubleToLongBits(other.getX()))
			return false;
		if (Double.doubleToLongBits(getY()) != Double.doubleToLongBits(other.getY()))
			return false;
		if (Double.doubleToLongBits(getZ()) != Double.doubleToLongBits(other.getZ()))
			return false;
		return true;
	}
	
	/**
	 * @methodtype query
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(getX());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getY());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getZ());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * @methodtype assert
	 */
	private void assertCoordinateNotNull(Coordinate c) {
		if (c == null) {
			throw new NullPointerException("coordinate must not be null");
		}
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertIsDoubleValue(double val) {
		assert !Double.isNaN(val);
	}

	/**
	 * a method, to implement postconditions
	 * 
	 * @methodtype assertion
	 */
	protected void assertIsNotNull(Object val) {
		if (val == null) {
			throw new NullPointerException("Object must not be null");
		}
	}

	/**
	 * Class invariant assertion method
	 * 
	 * @methodtype assertion
	 */
	protected abstract void assertClassInvariants();

}
