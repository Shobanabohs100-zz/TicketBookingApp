package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.dto.ErrorDTO;
import com.simple.dto.LoginDTO;
import com.simple.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value="/login", method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object login(@RequestBody LoginDTO loginDTO){
		Object object;
		try {
			object = loginService.login(loginDTO);
			
		}catch(DataAccessResourceFailureException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Database Service Unavailable" + ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.SERVICE_UNAVAILABLE);
		}catch(Exception ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Exception occurs " + ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.PARTIAL_CONTENT);
		}
		
		if(object instanceof ErrorDTO){
			return new ResponseEntity<Object>(object,HttpStatus.BAD_REQUEST);
		} else {
			
			return new ResponseEntity<Object>(object,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/logout/user/{userInfoId}/token/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object logout(@PathVariable(value="userInfoId") String userInfoId, @PathVariable(value="token") String token) {
		try {
			loginService.logout(userInfoId, token);
			
		}catch(DataAccessResourceFailureException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Database Service Unavailable" + ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.SERVICE_UNAVAILABLE);
		}catch(Exception ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Exception occurs " + ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.PARTIAL_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
