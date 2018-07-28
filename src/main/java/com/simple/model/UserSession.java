package com.simple.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The UserSession Class represent the user_session table as model
 * @author sriram
 * @since 25/12/2017
 */
@Entity
@Table(name="user_session")
public class UserSession extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6730882831895477968L;


	@Column(name="user_id")
	private String userInfoId;
	
	
	@Column(name="session_token")
	private String sessionToken;

	@Column(name="expiration_time")
	private Timestamp expirationDtTm;

	
	/**
	 * @return the userInfoId
	 */
	public String getUserInfoId() {
		return userInfoId;
	}


	/**
	 * @param userInfoId the userInfoId to set
	 */
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}


	/**
	 * @return the sessionToken
	 */
	public String getSessionToken() {
		return sessionToken;
	}


	/**
	 * @param sessionToken the sessionToken to set
	 */
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}


	/**
	 * @return the expirationDtTm
	 */
	public Timestamp getExpirationDtTm() {
		return expirationDtTm;
	}


	/**
	 * @param expirationDtTm the expirationDtTm to set
	 */
	public void setExpirationDtTm(Timestamp expirationDtTm) {
		this.expirationDtTm = expirationDtTm;
	}



}
