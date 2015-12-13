/**
 * CartesianCoordinate
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

import java.io.Serializable;

/**
 * 
 * Implementation of the CartesianCoordinate class This class holds the
 * Coordinates in x,y and z values
 *
 */
public class CartesianCoordinate extends AbstractCoordinate implements Serializable {

	final private double x;
	final private double y;
	final private double z;

	/**
	 * @methodtype constructor
	 */
	private CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static Coordinate getInstance(double x, double y, double z) {
		Coordinate result = instances.get(hashCode(x, y, z));
		if (result == null) {
			synchronized (instances) {
				result = instances.get(hashCode(x, y, z));
				if (result == null) {
					result = new CartesianCoordinate(x, y, z);
					instances.put(hashCode(x, y, z), result);
				}
			}
		}
		return result;
	}

	/**
	 * @methodtype get
	 */
	public double getX() {
		assertClassInvariants();
		return x;
	}

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setX(double x) {
		assertIsDoubleValue(x);
		assertClassInvariants();
		CartesianCoordinate result = new CartesianCoordinate(x, this.y, this.z);
		assertClassInvariants();
		return result;
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		assertClassInvariants();
		return y;
	}

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setY(double y) {
		assertIsDoubleValue(y);
		assertClassInvariants();
		CartesianCoordinate result = new CartesianCoordinate(this.x, y, this.z);
		assertClassInvariants();
		return result;
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		assertClassInvariants();
		return z;
	}

	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setZ(double z) {
		assertIsDoubleValue(z);
		assertClassInvariants();
		CartesianCoordinate result = new CartesianCoordinate(this.x, this.y, z);
		assertClassInvariants();
		return result;
	}

	/**
	 * @methodtype assert
	 */
	@Override
	protected void assertClassInvariants() {
		assertIsDoubleValue(x);
		assertIsDoubleValue(y);
		assertIsDoubleValue(z);
	}
}
