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
 * Implementation of the SphericCoordinate class
 * It holds the values as latitude, longitude and radius
 *
 */
public class SphericCoordinate extends AbstractCoordinate implements Serializable {

	private double latitude;
	private double longitude;
	private double radius;

	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate() {
		this(0.0, 0.0);
		assertClassInvariants();
	}

	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latidtude, double longitude, double radius) {
		assertIsDoubleValue(latidtude);
		assertIsLongitudeValid(longitude);
		assertIsValidRadius(radius);
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
	public void setLatitude(double latitude) {
		assertIsDoubleValue(latitude);
		assertIsLatitudeValid(latitude);
		assertClassInvariants();
		this.latitude = latitude;
		assertClassInvariants();
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
	public void setLongitude(double longitude) {
		assertIsDoubleValue(longitude);
		assertIsLongitudeValid(longitude);
		assertClassInvariants();
		this.longitude = longitude;
		assertClassInvariants();
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
	public void setRadius(double radius) {
		assertIsDoubleValue(radius);
		assertIsValidRadius(radius);
		assertClassInvariants();
		this.radius = radius;
		assertClassInvariants();
	}

	/**
	 * @methodtype boolean-query
	 */
	public int hashCode() {
		assertClassInvariants();
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		assertClassInvariants();
		return result;
	}

	// conversation to x,y and z:
	// from
	// http://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
	/**
	 * @methodtype get
	 */
	public double getX() {
		assertClassInvariants();
		return getRadius() * Math.cos(Math.toRadians(getLatitude())) * Math.cos(Math.toRadians(getLongitude()));
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		assertClassInvariants();
		return getRadius() * Math.cos(Math.toRadians(getLatitude())) * Math.sin(Math.toRadians(getLongitude()));
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		assertClassInvariants();
		return getRadius() * Math.sin(Math.toRadians(getLatitude()));
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
