/**
 * 
 */
package com.simple.dto;

/**
 * @author suganapa
 *
 */
public class OfferDTO {
	
	private String id;
	
	private String travelId;
	
	private String desc;
	
	private double amount;

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
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
