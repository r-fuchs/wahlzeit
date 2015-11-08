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

import org.wahlzeit.services.DataObject;

public class SphericCoordinate extends DataObject implements Coordinate {

	private double latitude;
	private double longitude;
	private double radius;
	
	/**
	* @methodtype constructor
	*/
	public SphericCoordinate () {
		setLatitude(0);
		setLongitude(0);
		setRadius(Coordinate.EARTHRADIUS);
	}
	
	/**
	* @methodtype constructor
	*/
	public SphericCoordinate (double latidtude, double longitude, double radius) {
		setLatitude(latidtude);
		setLongitude(longitude);
		setRadius(radius);
	}
	
	/**
	* @methodtype constructor
	*/
	public SphericCoordinate (double latidtude, double longitude) {
		setLatitude(latidtude);
		setLongitude(longitude);
		setRadius(Coordinate.EARTHRADIUS);
	}
	
	/**
	* @methodtype get
	*/
	public double getLatitude() {
		return latitude;
	}

	/**
	* @methodtype set
	*/
	public void setLatitude(double latitude) {
		assertIsLatitudeValid(latitude);
		this.latitude = latitude;
	}

	/**
	* @methodtype get
	*/
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		assertIsLongitudeValid(longitude);
		this.longitude = longitude;
	}

	/**
	* @methodtype get
	*/
	public double getRadius() {
		return radius;
	}

	/**
	* @methodtype set
	*/
	public void setRadius(double radius) {
		this.radius = radius;
	}

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

	/**
	* @methodtype boolean-query
	*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
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
		SphericCoordinate other = (SphericCoordinate) c;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}


	//conversation to x,y and z:
	//from http://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
	/**
	* @methodtype get
	*/
	public double getX() {
		return getRadius() * Math.cos(Math.toRadians(getLatitude())) * Math.cos(Math.toRadians(getLongitude()));
	}

	/**
	* @methodtype get
	*/
	public double getY() {
		return getRadius() * Math.cos(Math.toRadians(getLatitude())) * Math.sin(Math.toRadians(getLongitude()));
	}

	/**
	* @methodtype get
	*/
	public double getZ() {
		return getRadius() * Math.sin(Math.toRadians(getLatitude()));
	}

	/**
	* @methodtype assert
	*/
	private void assertCordinateNull(Coordinate c){
	if (c==null){
		throw new NullPointerException("coordinate must not be null");
		}
	}
	/**
	* @methodtype assert
	*/
	private void assertIsLongitudeValid(double longitude){
		if (longitude < -180 ||  longitude > 180){
			throw new IllegalArgumentException("longitude must be between - 180 and 180");
		}
	}
	/**
	* @methodtype assert
	*/
	private void assertIsLatitudeValid(double latitude){
		if (latitude < -90 ||  latitude > 90){
			throw new IllegalArgumentException("latitude must be between - 90 and 90");
		}
	}	
}
