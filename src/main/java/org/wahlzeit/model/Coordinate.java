/**
 * Coordinate
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

/**
 * 
 * Implementation of the Coordinate interface.
 *
 */
public interface Coordinate {

	public static double EARTHRADIUS = 6371;

	/**
	 * 
	 * @param c
	 * @returns the distace as double value
	 * @methodtype: get
	 * 
	 */
	public double getDistance(Coordinate c);

	/**
	 * 
	 * @param c
	 * @returns boolean
	 * @methodtype: boolean query method
	 * 
	 */
	public boolean isEqual(Coordinate c);

	/**
	 * 
	 * @returns the x value
	 * @methodtype: get
	 * 
	 */
	public double getX();

	/**
	 * 
	 * @returns the y value
	 * @methodtype: get
	 * 
	 */
	public double getY();

	/**
	 * 
	 * @returns the z value
	 * @methodtype: get
	 * 
	 */
	public double getZ();

}
