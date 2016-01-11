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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class AppleType extends DataObject {

	@Id
	Long idLong = 1L;
	private static final long serialVersionUID = 1L;
	private double size;
	private double weight;
	private String name;
	protected AppleType superType = null;
	protected Set<AppleType> subTypes = new HashSet<AppleType>();

	/**
	 * @methodtype get
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @methodtype set
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * @methodtype get
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @methodtype set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
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

	/**
	 * @methodtype constructor
	 */
	public AppleType(AppleType superType, double size, double weight, String name) {
		this(size, weight, name);
		this.superType = superType;
	}

	/**
	 * @methodtype constructor
	 */
	public AppleType(double size, double weight, String name) {
		assert (size >= 0.0) : "Size must not be negative";
		assert (weight >= 0.0) : "Weight must not be negative";
		assert (name != null) : "Name must not be null";
		this.size = size;
		this.weight = weight;
		this.name = name;
	}

	/**
	 * @methodtype get
	 */
	public AppleType getSuperType() {
		return this.superType;
	}

	/**
	 * @methodtype set
	 */
	public void setSuperType(AppleType gt) {
		this.superType = gt;
	}

	/**
	 * @methodtype get
	 */
	public Iterator<AppleType> getSubTypesIterator() {
		return subTypes.iterator();
	}

	/**
	 * @methodtype set
	 */
	public void addSubType(AppleType at) {
		assert (at != null) : "Null must not be set as a subtype";
		at.setSuperType(this);
		subTypes.add(at);
	}

	/**
	 * @methodtype query
	 */
	public boolean isInstance(Apple apple) {
		assert (apple != null) : "Apple instance must not be null";
		if (apple.getType() == this) {
			return true;
		}
		for (AppleType type : subTypes) {
			if (type.isInstance(apple)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @methodtype: creation
	 */
	public Apple createInstance() {
		return new Apple(this);
	}
}