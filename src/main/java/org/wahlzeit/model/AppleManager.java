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

import java.util.HashMap;
import org.wahlzeit.services.DataObject;

/**
 *Handles AppleTypes
 */
public class AppleManager extends DataObject {

	private static AppleManager instance;

	/**
	 * @methodtype constructor
	 */
	private AppleManager() {
		//empty
	}

	/**
	 * @methodtype get
	 */
	public static AppleManager getInstance() {
		if (instance == null) {
			instance = new AppleManager();
		}
		return instance;
	}

	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Apple> apples = new HashMap<Integer, Apple>();
	private HashMap<String, AppleType> appleTypes = new HashMap<String, AppleType>();

	/**
	* @methodtype factory method
	*/
	public Apple createApple(String typeName) {
		AppleType at = getAppleType(typeName);
		assert (at != null) : "Invalid apple type name";
		Apple result = at.createInstance();
		apples.put(result.getId(), result);
		return result;
	}

	/**
	* @methodtype factory method
	*/
	public synchronized AppleType createAppleType(String typeName, double size, double weight, String name) {
		assert (!appleTypes.containsKey(typeName)) : "Type already exists";
		AppleType type = new AppleType(size, weight, name);
		appleTypes.put(typeName, type);
		return type;
	}

	/**
	 * @methodtype get
	 */
	public synchronized AppleType getAppleType(String typeName) {
		if (appleTypes.containsKey(typeName)) {
			return appleTypes.get(typeName);
		} else {
			return null;
		}
	}
}
