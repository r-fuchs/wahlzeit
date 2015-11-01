package org.wahlzeit.model;
import org.wahlzeit.services.DataObject;

/**
* Coordinate-Class implementation with basic functions
* 
*/
public class Coordinate {

	private final double EARTHRADIUS = 6371;
	
	//members
	private double latitude;
	private double longitude;
	
	//getter
	
	/**
	* @methodtype get
	*/
	public double getLatitude() {
		return latitude;
	}
	
	/**
	* @methodtype get
	*/
	public double getLongitude() {
		return longitude;
	}
	
	//setter
	
	/**
	* @methodtype set
	*/
	private void setLatidtude(double latitude) {
		assertIsLatitudeValid(latitude);
		this.latitude = latitude;
	}
	
	/**
	* @methodtype set
	*/
	private void setLongitude(double longitude) {
		assertIsLongitudeValid(longitude);
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
	* @return the distance in kilometer between the coordinates
	*@methodtype query
	*/
	public double getDistance (Coordinate c){
		double radLat1 = decimalToRad(getLatitude());
		double radLong1 = decimalToRad(getLongitude());
		double radLat2 = decimalToRad(c.getLatitude());
		double radLong2 = decimalToRad(c.getLongitude());
		
		return Math.acos(Math.sin(radLat1)*Math.sin(radLat2) +
				Math.cos(radLat1)*Math.cos(radLat2) *
				Math.cos(radLong2-radLong1))*EARTHRADIUS;
	}
	
	private double decimalToRad (double number) {
		return Math.PI*number/180;
	}

	/**
	* Calculates the latitudinal-distance between the coordinate and a second coordinate
	* @paramc c the second coordinate to calculate the latitudinal-distance from
	* @return the absolute latitudinal-distance
	* @methodtype query
	*/
	public double getLatitudinalDistance(Coordinate c){
		assertCordinateNull(c);
		return Math.abs(getLatitude()-c.getLatitude());
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
	private void assertIsLatitudeValid(double latitude){
		if (latitude < -90 ||  latitude > 90){
			throw new IllegalArgumentException("latitude must be between - 90 and 90");
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
	* Calculates the longitudina-distance between the coordinate and a second coordinate
	* @param c the second coordinate to calculate the longitudinal-distance from
	* @return the absolute longitudinal-distance
	* @methodtype query
	*/
	public double getLongitudinalDistance(Coordinate c){
		if (c==null){
			throw new NullPointerException("Coordinate must not be null");
		}
		return Math.abs(getLongitude()-c.getLongitude());
	}
	

	
}
