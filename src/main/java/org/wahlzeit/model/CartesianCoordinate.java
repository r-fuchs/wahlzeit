package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {

	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate () {
		setX(0);
		setY(0);
		setZ(0);
	}
	
	public CartesianCoordinate (double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
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
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean isEqual(Coordinate c) {
		if (this == c)
			return true;
		if (c == null)
			return false;
		if (getClass() != c.getClass())
			return false;
		CartesianCoordinate other = (CartesianCoordinate) c;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	//reffering to http://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
	public SphericCoordinate toSphericCoordinate(double radius)
	{
		double lat = Math.asin(getZ() / radius);
		double lon = Math.atan2(getY(), getX());
		return new SphericCoordinate(lat, lon);
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
