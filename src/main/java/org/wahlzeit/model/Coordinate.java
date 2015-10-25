package org.wahlzeit.model;

/**
* Coordinate-Class implementation with basic functions
* @version 1.0
*/

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
	/**
	* Calculates the distance between the coordinate and a second coordinate
	* @param c the second coordinate to calculate the distance from
	* @return the distance between the coordinates as a coordinate-object
	* @methodtype get
	*/
	public Coordinate getDistance (Coordinate c){
		return new Coordinate(getLatitudinalDistance(c), getLongitudinalDistance(c));
	}
	
	/**
	* Calculates the latitudinal-distance between the coordinate and a second coordinate
	* @paramc c the second coordinate to calculate the latitudinal-distance from
	* @return the absolute latitudinal-distance
	* @methodtype get
	*/
	public double getLatitudinalDistance(Coordinate c){
		return Math.abs(getLatidtude()-c.getLatidtude());
	}
	
	/**
	* Calculates the longitudina-distance between the coordinate and a second coordinate
	* @param c the second coordinate to calculate the longitudinal-distance from
	* @return the absolute longitudinal-distance
	* @methodtype get
	*/
	public double getLongitudinalDistance(Coordinate c){
		return Math.abs(getLongitude()-c.getLongitude());
	}
	
}
