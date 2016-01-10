package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.wahlzeit.services.DataObject;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class AppleType extends DataObject {
	private static final long serialVersionUID = 1L;
	private double size;
	private double weight;
	private String name;
	
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

	protected AppleType superType = null;
	protected Set<AppleType> subTypes = new HashSet<AppleType>();

	public AppleType(double size, double weight, String name) {
		assert (weight >= 0.0) : "Weight must not be negative";
		assert (name != null) : "Name must not be null";
		this.size = size;
		this.weight = weight;
		this.name = name;
	}

	public AppleType getSuperType() {
		return this.superType;
	}

	public Iterator<AppleType> getSubTypesIterator() {
		return subTypes.iterator();
	}

	public void addSubType(AppleType at) {
		assert (at != null) : "Null must not be set as a subtype";
		subTypes.add(at);
	}

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

	public Apple createInstance() {
		return new Apple(this);
	}
}