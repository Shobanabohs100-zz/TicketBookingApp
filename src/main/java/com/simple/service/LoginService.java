/**
 * 
 */
package com.simple.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simple.dto.ErrorDTO;
import com.simple.dto.LoginDTO;
import com.simple.dto.SessionDTO;
import com.simple.manager.UserManager;
import com.simple.model.UserInfo;
import com.simple.model.UserSecret;
import com.simple.model.UserSession;

/**
 * LoginService class to provide authentication to the user
 * @author Suriya
 * @since 20-Jul-2018
 *
 */
@Component
public class LoginService {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserService userService;
	
	/**
	 * Method to validate the username and password to access the system
	 * 
	 * @param loginDTO, The loginDTO is the Object of LoginDTO.
	 * @return {@link LoginDTO}
	 */
	public Object login(LoginDTO loginDTO) {
		
		ErrorDTO errorDTO = new ErrorDTO();
		
		UserInfo userInfo =  userManager.findUserInfoByUserEmail(loginDTO.getUserName());
		
		if(userInfo == null){
			
			errorDTO.setMessage("The User is not register with system, Please register and try");
			return errorDTO;
		}
		
		UserSecret userSecret = userManager.findUserSecretByUserInfoId(userInfo.getId());
		
		if(userSecret == null){
			errorDTO.setMessage("Password is not yet created. Set the password and try again");
			return errorDTO;
		}
		
		if(!userSecret.getSecret().equals(loginDTO.getPassword())){
			errorDTO.setMessage("Incorrect Password, Please verify the given password and try again");
			return errorDTO;
		}
		
		UserSession userSession = createUserSession(userInfo.getId());	
		
		SessionDTO sessionDTO = new SessionDTO();
		sessionDTO.setUserInfoId(userInfo.getId());
		sessionDTO.setSessionToken(userSession.getSessionToken());
		return sessionDTO;
	}
	

	
	/**
	 * Method to created User session by user info Id
	 * 
	 * @param userInfoId, The userInfoId is primary Id of UserInfoId.
	 * @return {@link UserSession}
	 */
	private UserSession createUserSession(String userInfoId) {
		UserSession userSession = new UserSession();
		userSession.setUserInfoId(userInfoId);
		userSession.setSessionToken(getToken());
		
		Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DAY_OF_YEAR, 1);
	    userSession.setExpirationDtTm(new Timestamp(cal.getTimeInMillis()));
	    
		return userManager.saveUserSession(userSession);
	}

	
	/**
	 * Method to generate the random number to maintain session token
	 * @return String
	 */
	private String getToken() {
		
		SecureRandom random;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			random = new SecureRandom();
		} 
		random.setSeed(random.generateSeed(10)); 
		return String.valueOf(Math.abs(random.nextLong()));
	}
	
	public void logout(String userInfoId, String token) {
		
		UserSession userSession =  userService.findUserSessionByTokenAndUserId(token, userInfoId);
		
		if(userSession != null) {
			userSession.setActive(false);
			userManager.saveUserSession(userSession);
		}
	}
	

}
