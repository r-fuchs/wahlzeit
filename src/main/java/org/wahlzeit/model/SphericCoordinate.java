/**
 * SphericCoordinate
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
 * Implementation of the SphericCoordinate class It holds the values as
 * latitude, longitude and radius
 *
 */
public class SphericCoordinate extends AbstractCoordinate implements Serializable {

	final private double latitude;
	final private double longitude;
	final private double radius;

	/**
	 * @methodtype constructor
	 */
	private SphericCoordinate() {
		this(0.0, 0.0);
		assertClassInvariants();
	}

	/**
	 * @methodtype constructor
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude, double radius){
		double x = doGetX();
		double y =doGetY();
		double z = dogetZ();
		SphericCoordinate result = instances.get
		setLatitude(latidtude);
		setLongitude(longitude);
		setRadius(radius);
		assertClassInvariants();
	}

	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latidtude, double longitude) {
		this(latidtude, longitude, Coordinate.EARTHRADIUS);
	}

	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		assertClassInvariants();
		return latitude;
	}

	/**
	 * @methodtype set
	 */
	public SphericCoordinate setLatitude(double latitude) {
		assertIsDoubleValue(latitude);
		assertIsLatitudeValid(latitude);
		assertClassInvariants();
		SphericCoordinate result = new SphericCoordinate(latitude, this.getLongitude(), this.getRadius());
		assertClassInvariants();
		return result;
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		assertClassInvariants();
		return longitude;
	}

	/**
	 * @methodtype set
	 */
	public SphericCoordinate setLongitude(double longitude) {
		assertIsDoubleValue(longitude);
		assertIsLongitudeValid(longitude);
		assertClassInvariants();
		SphericCoordinate result = new SphericCoordinate(this.getLatitude(), longitude, this.getRadius());
		assertClassInvariants();
		return result;
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		assertClassInvariants();
		return radius;
	}

	/**
	 * @methodtype set
	 */
	public SphericCoordinate setRadius(double radius) {
		assertIsDoubleValue(radius);
		assertIsValidRadius(radius);
		assertClassInvariants();
		SphericCoordinate result = new SphericCoordinate(this.getLatitude(), this.getLongitude(), radius);
		assertClassInvariants();
		return result;
	}

	/**
	 * @methodtype assert
	 */
	private void assertIsLongitudeValid(double longitude) {
		if (longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException("longitude must be between - 180 and 180");
		}
	}

	/**
	 * @methodtype assert
	 */
	private void assertIsLatitudeValid(double latitude) {
		if (latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException("latitude must be between - 90 and 90");
		}
	}

	/**
	 * @methodtype assert
	 */
	private void assertIsValidRadius(double radius) {
		if (radius < 0) {
			throw new IllegalArgumentException("radius must be bigger than 0");
		}
	}

	/**
	 * @methodtype primitive helper
	 */
	private static double doGetX(double latitude, double longitude, double radius) {
		return radius * Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
	}

	/**
	 * @methodtype primitive helper
	 */
	private static double doGetY(double latitude, double longitude, double radius) {
		return radius * Math.cos(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
	}

	/**
	 * @methodtype primitive helper
	 */
	private static double dogetZ(double latitude, double longitude, double radius) {
		return radius * Math.sin(Math.toRadians(latitude));
	}

	/**
	 * @methodtype assert
	 */
	@Override
	protected void assertClassInvariants() {
		assertIsDoubleValue(latitude);
		assertIsDoubleValue(longitude);
		assertIsDoubleValue(radius);
		assertIsLatitudeValid(latitude);
		assertIsLongitudeValid(longitude);
		assertIsValidRadius(radius);
	}

}
