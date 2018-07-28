/**
 * 
 */
package com.simple.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simple.model.UserInfo;
import com.simple.model.UserSecret;
import com.simple.model.UserSession;
import com.simple.repository.UserRepository;
import com.simple.repository.UserSecretRepository;
import com.simple.repository.UserSessionRepository;

/**
 * @author suganapa
 *
 */
@Component
public class UserManager {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public UserSecretRepository userSecretRepository;
	
	@Autowired
	public UserSessionRepository userSessionRepository;
	
	/**
	 * The method to find the user info details by email address
	 * @param emailAddress, The emailAddress is String data type value.
	 * @return list of {@link UserInfo}
	 */
	public UserInfo findUserInfoByUserEmail(String emailAddress) {
		return userRepository.findByEmailAddress(emailAddress);
	}
	
	/**
	 * The method to find the user secret by user info Id
	 * @param userInfoId, The userInfoId is String data type value
	 * @return {@link UserSecret}
	 */
	public UserSecret findUserSecretByUserInfoId(String userInfoId) {
		return userSecretRepository.findByUserInfoIdAndIsActiveTrue(userInfoId);
	}
	
	/**
	 * The method to create the user session
	 * @param userSession, The Usersession object
	 * @return {@link UserSession}
	 */
	public UserSession saveUserSession(UserSession userSession) {
		return userSessionRepository.save(userSession);
	}
	
	/**
	 * Method to find the user session by token
	 * @param userInfoId, the primary id of the user
	 * @param token, The token is the unique session Id.
	 * @return {@link UserSession}
	 */
	public UserSession findUserSessionByTokenAndUserInfo(String token, String userInfoId) {
		return userSessionRepository.findUserSessionByTokenAndUserInfo(token, userInfoId);
	}
	
	/**
	 * Method to create/save user
	 * 
	 * @param user, The user object
	 * @return {@link UserInfo}
	 */
	public UserInfo saveUser(UserInfo user) {
		return userRepository.save(user);
	}
	
	/**
	 * Method to save the user secret
	 * 
	 * @param userSecret, the object of UserSecret
	 * @return {@link UserSecret}
	 */
	public UserSecret saveUserSecret(UserSecret userSecret) {
		return userSecretRepository.save(userSecret);
	}
	
	/**
	 * Method to find user by id
	 * 
	 * @param id, primary key of the user
	 * @return {@link String}
	 */
	public UserInfo findUserInfoById(String id) {
		return userRepository.findByIdAndIsActiveTrue(id );
	}
}
