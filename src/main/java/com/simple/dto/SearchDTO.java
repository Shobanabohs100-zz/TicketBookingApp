/**
 * 
 */
package com.simple.dto;

/**
 * @author suganapa
 *
 */
public class SearchDTO {
	
	private String source;
	
	private String destination;
	
	private String tvlDate;

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}


	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
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
}
