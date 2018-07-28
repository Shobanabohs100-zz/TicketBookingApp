/**
 * 
 */
package com.simple.dto;

import java.util.List;

/**
 * @author suganapa
 *
 */
public class TravellerBusDTO extends BaseDTO{
	
	private String userId;
	
	private String travelId;
	
	private String offerId;
	
	private String boardingPointId;
	
	private String dropPointId;
	
	private List<TravellerDTO> travellerDTO;
	
	private double fare;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return the offerId
	 */
	public String getOfferId() {
		return offerId;
	}

	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	/**
	 * @return the boardingPointId
	 */
	public String getBoardingPointId() {
		return boardingPointId;
	}

	/**
	 * @param boardingPointId the boardingPointId to set
	 */
	public void setBoardingPointId(String boardingPointId) {
		this.boardingPointId = boardingPointId;
	}

	/**
	 * @return the dropPointId
	 */
	public String getDropPointId() {
		return dropPointId;
	}

	/**
	 * @param dropPointId the dropPointId to set
	 */
	public void setDropPointId(String dropPointId) {
		this.dropPointId = dropPointId;
	}

	/**
	 * @return the travellerDTO
	 */
	public List<TravellerDTO> getTravellerDTO() {
		return travellerDTO;
	}

	/**
	 * @param travellerDTO the travellerDTO to set
	 */
	public void setTravellerDTO(List<TravellerDTO> travellerDTO) {
		this.travellerDTO = travellerDTO;
	}

	/**
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}
}
