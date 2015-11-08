package org.wahlzeit.model;

public interface Coordinate {

	public static double EARTHRADIUS = 6371;

	public double getDistance(Coordinate c);
	public boolean isEqual(Coordinate c);
	
	public double getX();
	public double getY();
	public double getZ();
	
}
