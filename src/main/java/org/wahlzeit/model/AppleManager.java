package org.wahlzeit.model;

import java.util.HashMap;
import org.wahlzeit.services.DataObject;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class AppleManager extends DataObject {
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Apple> apples = new HashMap<Integer, Apple>();
	private HashMap<String, AppleType> appleTypes = new HashMap<String, AppleType>();

	public Apple createApple(String typeName) {
		AppleType at = getAppleType(typeName);
		assert (at != null) : "Invalid apple type name";
		Apple result = at.createInstance();
		apples.put(result.getId(), result);
		return result;
	}

	public synchronized void createAppleType(String typeName, double size, double weight, String name) {
		assert (!appleTypes.containsKey(typeName)) : "Type already exists";
		AppleType type = new AppleType(size, weight, name);
		appleTypes.put(typeName, type);
	}

	public synchronized AppleType getAppleType(String typeName) {
		if (appleTypes.containsKey(typeName)) {
			return appleTypes.get(typeName);
		} else {
			return null;
		}
	}
}
