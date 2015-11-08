package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {

	private double x;
	private double y;
	private double z;
	
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		// TODO Auto-generated method stub
		return false;
	}

}
