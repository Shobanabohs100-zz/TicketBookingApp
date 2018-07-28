package com.simple.controller;
import java.text.ParseException;

import javax.xml.bind.ValidationException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.dto.ErrorDTO;
import com.simple.dto.SuccessDTO;
import com.simple.dto.UserDTO;
import com.simple.exception.SessionNotExistException;
import com.simple.model.UserInfo;
import com.simple.service.UserService;
import com.simple.util.Constants;

/**
 * The User Controller provides the services for the user actions
 * @author Suriya
 * @since 20/07/2018
 */

@Controller
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user", method = RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Object createUser(@RequestBody UserDTO userDTO) {

		Object object;
		try {
			userService.validateUser(userDTO);
			
		} catch (ValidationException e) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("User Info missing");
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.BAD_REQUEST);
		}
		try {
			object = userService.createUser(userDTO);
			
		} catch (ParseException e) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Date parsing exception");
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
			
		}catch(DataIntegrityViolationException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Data Integerity violation while saving the data");
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
			
		}catch(Exception ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Can't create the user");
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(object instanceof ErrorDTO) {
			return new ResponseEntity<Object>(object,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			UserInfo user = (UserInfo) object;
			SuccessDTO successDTO = new SuccessDTO();
			successDTO.setMessage("User Created Successfully");
			successDTO.setId(user.getId());
			return new ResponseEntity<Object>(successDTO, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/update-user", method = RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public Object updateUser(@RequestBody UserDTO userDTO, @RequestHeader("Access-Token") String token, @RequestHeader("userId") String userId) {

		Object object;
		try {
			validateSession(token, userId);
			
		}catch(SessionNotExistException ex){
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(Constants.INVALID_SESSION+ex);
			return new ResponseEntity<Object>(errorDTO,HttpStatus.UNAUTHORIZED);
		}
		try {
			userService.validateUser(userDTO);
			
		} catch (ValidationException e) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("User Info missing");
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		try {
			object = userService.updateUser(userDTO);
			
		}catch(DataIntegrityViolationException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Data Integerity violation while saving the data");
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
			
		}catch(Exception ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Can't update the user "+ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(object instanceof ErrorDTO) {
			return new ResponseEntity<Object>(object,HttpStatus.BAD_REQUEST);
		}else {
			UserInfo user = (UserInfo) object;
			SuccessDTO successDTO = new SuccessDTO();
			successDTO.setMessage("User updated Successfully");
			successDTO.setId(user.getId());
			return new ResponseEntity<Object>(successDTO, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/user/{userId}", method = RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
	public Object deleteUser(@PathVariable("userId") String userId,  @RequestHeader("Access-Token") String token) {
		
		try {
			validateSession(token, userId);
			
		}catch(SessionNotExistException ex){
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(Constants.INVALID_SESSION+ex);
			return new ResponseEntity<Object>(errorDTO,HttpStatus.UNAUTHORIZED);
		}
		try {
			userService.deleteUser(userId);
			
		}catch(ObjectNotFoundException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.BAD_REQUEST);
		}
		SuccessDTO successDTO = new SuccessDTO();
		successDTO.setMessage("User deleted Successfully");
		successDTO.setId(userId);
		return new ResponseEntity<Object>(successDTO, HttpStatus.OK);
	}
}
