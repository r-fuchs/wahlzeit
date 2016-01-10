package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class Apple extends DataObject {
	private static final long serialVersionUID = 1L;
	private AppleType appleType = null;
	private static int currentId = 0;
	private int id;

	public Apple(AppleType at) {
		assert (at != null) : "Null must not be a type";
		this.appleType = at;
		id = currentId++;
	}

	public AppleType getType() {
		return this.appleType;
	}

	public int getId() {
		return this.id;
	}
}