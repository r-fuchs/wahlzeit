package org.wahlzeit.model;

 public class Location {
	private String name;
	private Coordinate coordinate;
	
	/**
	 * @methodtype convenience constructor
	 */
	public Location(double x, double y, double z) {
		this.coordinate = new CartesianCoordinate(x,y,z);
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
