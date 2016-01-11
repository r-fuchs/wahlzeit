/*
 * Copyright (c) Richard Fuchs
 *
 * This file is part of the Wahlzeit photo rating application.
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

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Apple extends DataObject {
	@Id
	Long idLong = 1L;
	private static final long serialVersionUID = 1L;

	@Container
	private AppleType appleType = null;

	private static int currentId = 0;
	private int id;

	/**
	 * @methodtype: constructor
	 */
	public Apple(AppleType at) {
		assert (at != null) : "Null must not be a type";
		this.appleType = at;
		id = currentId++;
	}

	/**
	 * @methodtype: get
	 */
	public AppleType getType() {
		return this.appleType;
	}

	/**
	 * @methodtype: get
	 */
	public int getId() {
		return this.id;
	}
}