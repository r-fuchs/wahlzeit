package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

	private double latitude;
	private double longitude;
	private double radius;
	
	public SphericCoordinate () {
		setLatitude(0);
		setLongitude(0);
		setRadius(Coordinate.EARTHRADIUS);
	}
	
	public SphericCoordinate (double latidtude, double longitude, double radius) {
		setLatitude(latidtude);
		setLongitude(longitude);
		setRadius(radius);
	}
	
	public SphericCoordinate (double latidtude, double longitude) {
		setLatitude(latidtude);
		setLongitude(longitude);
		setRadius(Coordinate.EARTHRADIUS);
	}
	
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

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
	//pythagoras:	
		return Math.sqrt(
				Math.pow(c.getX() - this.getX(), 2) 
				+ Math.pow(c.getY() - this.getY(), 2) 
				+ Math.pow(c.getZ() - this.getZ(), 2));
	}

	@Override
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

	public CartesianCoordinate toCartesianCoordinate()
	{
		return new CartesianCoordinate(getX(), getY(), getZ());
	}

	//conversation to x,y and z:
	//from http://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
	public double getX() {
		return getRadius() * Math.cos(Math.toRadians(getLatitude())) * Math.cos(Math.toRadians(getLongitude()));
	}

	public double getY() {
		return getRadius() * Math.cos(Math.toRadians(getLatitude())) * Math.sin(Math.toRadians(getLongitude()));
	}

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
}
