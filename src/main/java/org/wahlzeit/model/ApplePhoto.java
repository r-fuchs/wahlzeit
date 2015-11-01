package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index=true)
public class ApplePhoto extends Photo {

	
	private double size;
	private double weight;
	private String Name;


	/**
	* @methodtype constructor
	*/
	public ApplePhoto(){
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
		return Name;
	}

	/**
	* @methodtype set
	*/
	public void setName(String name) {
		Name = name;
	}
}
