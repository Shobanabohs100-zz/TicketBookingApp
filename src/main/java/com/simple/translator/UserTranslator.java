/**
 * 
 */
package com.simple.translator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.simple.dto.UserDTO;
import com.simple.model.UserInfo;

/**
 * UserTranslator class to translate the user model to user DTO and vice versa
 * @author Suriya
 * @since 20-Jul-2018
 */
@Component
public class UserTranslator {
	
	/**
	 * Method to translate userDTO to user
	 * 
	 * @param userDTO, The userDTO is the Object of UserDTO 
	 * @return {@link UserInfo}
	 * @throws ParseException 
	 */
	public UserInfo translateUSerDTO(UserDTO userDTO, UserInfo userInfo) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		BeanUtils.copyProperties(userDTO, userInfo);
		userInfo.setDob(dateFormat.parse(userDTO.getDob()));
		return userInfo;
	}
	
	/**
	 * Method to translate userInfo to userDTO
	 * 
	 * @param user, The user is the Object of UserInfo
	 * @return {@link UserDTO}
	 */
	public UserDTO translateUserInfo(UserInfo user) {
		
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}
}
