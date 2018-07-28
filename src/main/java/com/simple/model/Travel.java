/**
 * 
 */
package com.simple.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author suganapa
 *
 */

@Entity
@Table(name="travel")
public class Travel extends BaseModel{
	
	@Column(name="name")
	private String name;
	
	@Column(name="is_ac")
	private boolean isAC;
	
	@Column(name="bus_type")
	private String busType;
	
	@Column(name="total_seat")
	private int totalSeat;
	
	@Column(name="available_seat")
	private int availableSeat;
	
	@Column(name = "free_seat")
	private String freeSeat;
	
	@Column(name="fare")
	private double fare;
	
	@Column(name="arrival_time")
	private String arrivalTime;
	
	@Column(name="duration")
	private double duration;
	
	@Column(name = "tvl_date")
	private String tvlDate;
	
	@OneToOne
	@JoinColumn(name = "location_id")
	private Location location;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isAC
	 */
	public boolean isAC() {
		return isAC;
	}

	/**
	 * @param isAC the isAC to set
	 */
	public void setAC(boolean isAC) {
		this.isAC = isAC;
	}

	/**
	 * @return the busType
	 */
	public String getBusType() {
		return busType;
	}

	/**
	 * @param busType the busType to set
	 */
	public void setBusType(String busType) {
		this.busType = busType;
	}

	/**
	 * @return the totalSeat
	 */
	public int getTotalSeat() {
		return totalSeat;
	}

	/**
	 * @param totalSeat the totalSeat to set
	 */
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	/**
	 * @return the availableSeat
	 */
	public int getAvailableSeat() {
		return availableSeat;
	}

	/**
	 * @param availableSeat the availableSeat to set
	 */
	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	/**
	 * @return the freeSeat
	 */
	/*public String getFreeSeat() {
		return freeSeat;
	}*/

	/**
	 * @param freeSeat the freeSeat to set
	 */
	/*public void setFreeSeat(String freeSeat) {
		this.freeSeat = freeSeat;
	}*/

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
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	/**
	 * @return the tvlDate
	 */
	public String getTvlDate() {
		return tvlDate;
	}

	/**
	 * @param tvlDate the tvlDate to set
	 */
	public void setTvlDate(String tvlDate) {
		this.tvlDate = tvlDate;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the freeSeat
	 */
	public String getFreeSeat() {
		return freeSeat;
	}

	/**
	 * @param freeSeat the freeSeat to set
	 */
	public void setFreeSeat(String freeSeat) {
		this.freeSeat = freeSeat;
	}
}
