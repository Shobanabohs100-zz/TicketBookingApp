package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.simple.exception.SessionNotExistException;
import com.simple.model.UserSession;
import com.simple.service.UserService;


public class BaseController {

	@Autowired
	UserService userService;
	
	public Object validateSession(String sessionToken, String userInfoId) throws SessionNotExistException{
		
		if( sessionToken == null){
			throw new SessionNotExistException("Not a valid Session");
		} else {
			UserSession userSession = userService.findUserSessionByTokenAndUserId(sessionToken,userInfoId );
			if(userSession == null){
				throw new SessionNotExistException("Session Expires");
			} else {
				return null;
			}
		}
		
	}
		
}
