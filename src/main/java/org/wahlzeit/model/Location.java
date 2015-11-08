package org.wahlzeit.model;

 public class Location {
	private String name;
	private Coordinate coordinate;
	
	/**
	 * @methodtype convenience constructor
	 */
	public Location(double latitude, double longitude) {
		this.coordinate = new SphericCoordinate(latitude,longitude);
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
