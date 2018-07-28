package com.simple.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The UserSecret Class represent the user_secret table as model
 * @author sriram
 * @since 25/12/2017
 */
@Entity
@Table(name="user_secret")
public class UserSecret extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5858421007762336989L;


	@Column(name="user_id")
	private String userInfoId;
	
	
	@Column(name="user_secret")
	private String secret;
	

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
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}


	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
}
