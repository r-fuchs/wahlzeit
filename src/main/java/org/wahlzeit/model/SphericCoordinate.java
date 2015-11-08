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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
