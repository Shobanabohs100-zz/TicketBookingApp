/**
 * 
 */
package com.simple.dto;

import java.util.List;

/**
 * @author suganapa
 *
 */
public class FreeSeatDTO extends BaseDTO{
	
	List<String> seats;

	/**
	 * @return the seats
	 */
	public List<String> getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
}
