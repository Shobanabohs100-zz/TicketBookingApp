package com.simple.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

/**
 * The BaseModel class is the super class for all the model 
 * 				And its implements the {@link Serializable} Interface for date serialize.
 * @author sriram
 * @since 25/12/2017
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseModel implements Serializable{

	@Id
	@Column(name = "id")
	private String id;
	
	
	@Column(name = "is_active")
	private boolean isActive;


	@PrePersist
	public void prePersist() {
		
		isActive=true;
		
		if(id ==null){
			id = UUID.randomUUID().toString();
		}
     }
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}


	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
