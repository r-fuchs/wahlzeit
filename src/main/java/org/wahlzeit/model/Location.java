package org.wahlzeit.model;

 public class Location {
	private String name;
	private Coordinate coordinate;


	/**
	 * @methodtype convenience constructor
	 */
	public Location(double latitude, double longitude) {
		this.coordinate = new Coordinate(latitude, longitude);
	}
	

	/**
	 * @methodtype constructor
	 */
	public Location(double latitude, double longitude, String name) {
		this.coordinate = new Coordinate(latitude, longitude);
		this.name = name;
	}
	
	/**
	 * @methodtype get
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * @methodtype get
	 */
	public String getName() {
		return name;
	}

	/**
	 * @methodtype set
	 */
	public void setName(String name) {
		this.name = name;
	}


}
