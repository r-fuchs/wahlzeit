package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

	private double latitude;
	private double longitude;
	private double radius;
	
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
		return 0;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		return false;
	}

}
