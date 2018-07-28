/**
 * 
 */
package com.simple.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author suganapa
 *
 */
@Entity
@Table(name="stop_detail")
public class BusStopPoint extends BaseModel{

	@Column(name="travel_id")
	private String travelId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="place")
	private String place;

	/**
	 * @return the travelId
	 */
	public String getTravelId() {
		return travelId;
	}

	/**
	 * @param travelId the travelId to set
	 */
	public void setTravelId(String travelId) {
		this.travelId = travelId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
}
