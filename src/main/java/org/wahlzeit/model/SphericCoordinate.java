package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

	private double latitude;
	private double longitude;
	private double radius;
	
	public SphericCoordinate () {
		setLatitude(0);
		setLongitude(0);
	}
	
	public SphericCoordinate (double latidtude, double longitude) {
		setLatitude(latidtude);
		setLongitude(longitude);
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

	@Override
	public double getDistance(Coordinate c) {

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

	//reffering to http://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
	//implementation just for fun
	public CartesianCoordinate toCartesianCoordinate()
	{
		double x = Coordinate.EARTHRADIUS * Math.cos(getLatitude()) * Math.cos(getLongitude());
		double y = Coordinate.EARTHRADIUS * Math.cos(getLatitude()) * Math.sin(getLongitude());
		double z = Coordinate.EARTHRADIUS * Math.sin(getLatitude());
		return new CartesianCoordinate(x, y, z);
	}
	
}
