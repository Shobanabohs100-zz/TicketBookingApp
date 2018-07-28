/**
 * 
 */
package com.simple.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author suganapa
 *
 */
@Entity
@Table(name="traveller_bus")
public class TravellerBus extends BaseModel{

	@Column(name="user_id")
	private String userId;
	
	@Column(name="travel_id")
	private String travelId;
	
	@Column(name="offer_id")
	private String offerId;
	
	@Column(name="boarding_point")
	private String boardingPointId;
	
	@Column(name="drop_point")
	private String dropPointId;

	@Column(name="fare")
	private double fare;
	
	@OneToMany(mappedBy="travellerBus")
	private List<Traveller> traveller;
	
	@OneToOne
	@JoinColumn(name = "boarding_point", insertable=false, updatable=false)
	private BusStopPoint boardingPoint;
	
	@OneToOne
	@JoinColumn(name = "drop_point", insertable=false, updatable=false)
	private BusStopPoint dropPoint;
	
	@ManyToOne
	@JoinColumn(name="travel_id", insertable=false, updatable=false)
	private Travel travel;

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
	 * @return the boardingPoint
	 */
	public BusStopPoint getBoardingPoint() {
		return boardingPoint;
	}

	/**
	 * @param boardingPoint the boardingPoint to set
	 */
	public void setBoardingPoint(BusStopPoint boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	/**
	 * @return the dropPoint
	 */
	public BusStopPoint getDropPoint() {
		return dropPoint;
	}

	/**
	 * @param dropPoint the dropPoint to set
	 */
	public void setDropPoint(BusStopPoint dropPoint) {
		this.dropPoint = dropPoint;
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

	/**
	 * @return the travel
	 */
	public Travel getTravel() {
		return travel;
	}

	/**
	 * @param travel the travel to set
	 */
	public void setTravel(Travel travel) {
		this.travel = travel;
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
	 * @return the traveller
	 */
	public List<Traveller> getTraveller() {
		return traveller;
	}

	/**
	 * @param traveller the traveller to set
	 */
	public void setTraveller(List<Traveller> traveller) {
		this.traveller = traveller;
	}
	
}
