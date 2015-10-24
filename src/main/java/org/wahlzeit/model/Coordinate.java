package org.wahlzeit.model;

public class Coordinate {

	//members
	private double latidtude;
	private double longitude;
	
	//getter
	public double getLatidtude() {
		return latidtude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	//setter
	private void setLatidtude(double latidtude) {
		this.latidtude = latidtude;
	}
	private void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	//constructor
	public Coordinate (double latidtude, double longitude) {
		setLatidtude(latidtude);
		setLongitude(longitude);
	}
	
	//functions
	public Coordinate getDistance (Coordinate c){
		return new Coordinate(getLatitudinalDistance(c), getLongitudinalDistance(c));
	}
	
	public double getLatitudinalDistance(Coordinate c){
		return getLatidtude()-c.latidtude;
	}
	
	public double getLongitudinalDistance(Coordinate c){
		return getLongitude()-c.getLongitude();
	}
	
}
