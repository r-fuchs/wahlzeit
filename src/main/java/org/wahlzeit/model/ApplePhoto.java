 /**
  * ApplePhoto
  * 
  * Copyright (c) by Richard Fuchs
  *
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as
  * published by the Free Software Foundation, either version 3 of the
  * License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  *
  * You should have received a copy of the GNU Affero General Public
  * License along with this program. If not, see
  * <http://www.gnu.org/licenses/>.
  */


package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index = true)
public class ApplePhoto extends Photo {

	private Apple apple;

	/**
	 * @methodtype constructor
	 */
	public ApplePhoto() {
		super();
	}

	/**
	 * @methodtype constructor
	 */
	public ApplePhoto(PhotoId id) {
		super(id);
	}

	/**
	 * @methodtype constructor
	 */
	public ApplePhoto(PhotoId id, double latitude, double longitude) {
		super(id, latitude, longitude);
	}

	/**
	 * @methodtype get
	 */
	public double getSize() {
		return apple.getType().getSize();
	}

	/**
	 * @methodtype set
	 */
	public void setSize(double size) {
		apple.getType().setSize(size);
	}

	/**
	 * @methodtype get
	 */
	public double getWeight() {
		return apple.getType().getSize();
	}

	/**
	 * @methodtype set
	 */
	public void setWeight(double weight) {
		apple.getType().setWeight(weight);
	}

	/**
	 * @methodtype get
	 */
	public String getName() {
		return apple.getType().getName();
	}

	/**
	 * @methodtype set
	 */
	public void setName(String name) {
		apple.getType().setName(name);
	}
}
