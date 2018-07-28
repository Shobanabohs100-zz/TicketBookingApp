/**
 * 
 */
package com.simple.service;

import java.text.ParseException;

import javax.xml.bind.ValidationException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simple.dto.ErrorDTO;
import com.simple.dto.UserDTO;
import com.simple.manager.UserManager;
import com.simple.model.UserInfo;
import com.simple.model.UserSession;
import com.simple.translator.UserTranslator;

/**
 * The UserService class to provide the services of the user actions
 * @author Suriya
 * 18-jul-2018
 */
@Component
public class UserService {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private UserTranslator userTranslator;
	
	/**
	 * Method to find the user session by token
	 * @param userInfoId, primary id of the user
	 * @param token, The token is the unique session Id.
	 * @return {@link UserSession}
	 */
	public UserSession findUserSessionByTokenAndUserId(String token, String userInfoId) {
		return userManager.findUserSessionByTokenAndUserInfo(token,userInfoId);
	}
	
	/**
	 * Method to create user
	 * 
	 * @param userDTO, object of the UserDTO
	 * @return {@link Object} response of the user creation
	 * @throws ParseException if dob format mismatch
	 */
	public Object createUser(UserDTO userDTO) throws ParseException{
		
		UserInfo userInfo;
		
		userInfo = userManager.findUserInfoByUserEmail(userDTO.getEmailAddress());
	
		if(userInfo != null) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("The User Already Exists with given email address");
			return errorDTO;
		}
		userInfo = userTranslator.translateUSerDTO(userDTO, new UserInfo());
		userManager.saveUser(userInfo);
		return userInfo;
	}
	
	/**
	 * Method to update the user
	 * 
	 * @param userDTO, object of the UserDTO
	 * @return {@link Object} response of the user creation
	 * @throws ParseException, if dob format mismatch 
	 */
	public Object updateUser(UserDTO userDTO) throws ParseException {
		
		UserInfo userInfo = userManager.findUserInfoByUserEmail(userDTO.getEmailAddress());
		
		userInfo = userTranslator.translateUSerDTO(userDTO, userInfo);
		userManager.saveUser(userInfo);
			
		return userInfo;
		
	}
	
	/**
	 * Method to delete the user by Id
	 * 
	 * @param userId, primary Id of the user
	 */
	public void deleteUser(String userId) {
		
		UserInfo userInfo = userManager.findUserInfoById(userId);
		
		if(userInfo != null) {
			userInfo.setActive(false);
			userManager.saveUser(userInfo);
		}else {
			throw new ObjectNotFoundException("User Not found for the userId ", userId); 
		}
		
	}
	
	/**
	 * Method to validate the userDTO
	 * 
	 * @param userDTO, object of the UserDTO
	 * @throws ValidationException if mandatory information missing
	 */
	public void validateUser(UserDTO userDTO) throws ValidationException {
		
		if(userDTO.getFirstName() == null || userDTO.getDob() == null || userDTO.getRole() == null) {
			throw new ValidationException("User Information missing");
		}
		if(userDTO.getEmailAddress() == null || userDTO.getPhoneNumber() == null || userDTO.getAddress() == null) {
			throw new ValidationException("User Information missing");
		}
	}

}
