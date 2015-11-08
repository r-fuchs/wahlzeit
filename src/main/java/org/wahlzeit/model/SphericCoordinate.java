package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

	@Override
	public double getDistance(Coordinate c) {
		return 0;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		return false;
	}

}
