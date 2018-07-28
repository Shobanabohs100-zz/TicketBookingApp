/**
 * 
 */
package com.simple.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Suriya
 * @since 17/07/2018
 *
 */
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
public class LoginDTO {

	private String userName;
	private String password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
