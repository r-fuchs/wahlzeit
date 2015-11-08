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
	public double getDistance(Coordinate c) {

	}

	@Override
	public boolean isEqual(Coordinate c) {

	}
	
	//reffering to http://stackoverflow.com/questions/1185408/converting-from-longitude-latitude-to-cartesian-coordinates
	//implementation just for fun
	public SphericCoordinate toSphericCoordinate()
	{
		double lat = Math.asin(getZ() / Coordinate.EARTHRADIUS);
		double lon = Math.atan2(getY(), getX());
		return new SphericCoordinate(lat, lon);
	}

}
