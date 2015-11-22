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

public class CartesianCoordinate extends AbstractCoordinate implements Serializable {

	private double x;
	private double y;
	private double z;

	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate() {
		setX(0);
		setY(0);
		setZ(0);
		assertClassInvariants();
	}

	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
		assertClassInvariants();
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
	public void setX(double x) {
		assertClassInvariants();
		this.x = x;
		assertClassInvariants();
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
	public void setY(double y) {
		assertClassInvariants();
		this.y = y;
		assertClassInvariants();
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
	public void setZ(double z) {
		assertClassInvariants();
		this.z = z;
		assertClassInvariants();
	}

	/**
	 * @methodtype boolean-query
	 */
	@Override
	public int hashCode() {
		assertClassInvariants();
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		assertClassInvariants();
		return result;
	}

	@Override
	protected void assertClassInvariants() {
		assertIsDoubleValue(x);
		assertIsDoubleValue(y);
		assertIsDoubleValue(z);
	}
}
