/**
 * 
 */
package com.simple.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.simple.dto.ErrorDTO;
import com.simple.dto.FreeSeatDTO;
import com.simple.dto.SearchDTO;
import com.simple.dto.SuccessDTO;
import com.simple.dto.TravellerBusDTO;
import com.simple.exception.SessionNotExistException;
import com.simple.service.TicketBookingService;
import com.simple.util.Constants;

/**
 * @author suganapa
 *
 */
@Controller
public class TicketBookingController extends BaseController{
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	@RequestMapping(value="/location", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getLocation(@RequestHeader("userId") String userId, @RequestHeader("Access-Token") String token, 
			@RequestParam(value = "locationType") String locationType) {
		
		Object object = null;
		try {
			validateSession(token, userId);
			
		}catch(SessionNotExistException ex){
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(Constants.INVALID_SESSION + ex);
			return new ResponseEntity<Object>(errorDTO,HttpStatus.UNAUTHORIZED);
		}
		try {
			object = ticketBookingService.getDropdownList(locationType);
		} catch (IOException e) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("IO Exception "+ e.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
			
		}catch(DataAccessResourceFailureException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Database Service Unavailable" + ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.SERVICE_UNAVAILABLE);
			
		}catch(Exception ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Can't get the location list "+ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}
	
	@RequestMapping(value="/available-seats/travel/{travelId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAvailableSeats(@RequestHeader("userId") String userId, @PathVariable(value = "travelId") String travelId,
			@RequestHeader("Access-Token") String token) {
		
		Object object;
		try {
			validateSession(token, userId);
			
		}catch(SessionNotExistException ex){
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(Constants.INVALID_SESSION + ex);
			return new ResponseEntity<Object>(errorDTO,HttpStatus.UNAUTHORIZED);
		}
		try {
			
			object = ticketBookingService.getFreeSeatsByTravelId(travelId);
			
		} catch(DataAccessResourceFailureException ex) {
		
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Database Service Unavailable" + ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.SERVICE_UNAVAILABLE);
		
		}catch(Exception ex) {
		
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Can't get the location list "+ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(object instanceof ErrorDTO) {
			
			return new ResponseEntity<Object>(object,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Object>(object,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/travel-detail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getTravelDetail(@RequestHeader("userId") String userId, @RequestBody SearchDTO searchDTO,
								@RequestHeader("Access-Token") String token){
		Object object;
		try {
			validateSession(token, userId);
			
		}catch(SessionNotExistException ex){
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(Constants.INVALID_SESSION + ex);
			return new ResponseEntity<Object>(errorDTO,HttpStatus.UNAUTHORIZED);
		}
		try {
		object = ticketBookingService.getTravelsBySourceAndDestAndDate(searchDTO.getSource(), searchDTO.getDestination(), searchDTO.getTvlDate());
		} catch(DataAccessResourceFailureException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Database Service Unavailable" + ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.SERVICE_UNAVAILABLE);
			
		}catch(Exception ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Can't get the location list "+ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(object instanceof ErrorDTO) {
			
			return new ResponseEntity<Object>(object,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Object>(object,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/bus-booking/user/{userId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createBooking(@PathVariable(value="userId") String userId, @RequestBody TravellerBusDTO travellerBusDTO,
			@RequestHeader("Access-Token") String token){
		try {
			validateSession(token, userId);
			
		}catch(SessionNotExistException ex){
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(Constants.INVALID_SESSION + ex);
			return new ResponseEntity<Object>(errorDTO,HttpStatus.UNAUTHORIZED);
		}
		try {
			ticketBookingService.bookingSeats(travellerBusDTO);
			
		}catch(DataAccessResourceFailureException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(Constants.DB_CONNECTION_ERROR);
			return new ResponseEntity<Object>(errorDTO,HttpStatus.BAD_REQUEST);
			
		}catch(JsonParseException | JsonMappingException ex) {
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage("Can't convert the json to object and vice versa "+ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,	HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch(Exception ex){
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(ex.getMessage());
			return new ResponseEntity<Object>(errorDTO,HttpStatus.BAD_REQUEST);
		}
		SuccessDTO successDTO = new SuccessDTO();
		successDTO.setMessage("Booked Successfully");
		return new ResponseEntity<Object>(successDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cancel-booking/bookingId/{bookingId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object cancelSeats(@RequestHeader("userId") String userId, @PathVariable(value = "bookingId") String bookingId,
			@RequestHeader("Access-Token") String token, @RequestBody FreeSeatDTO travellerDTO) {
		
		Object object = null;
		try {
			validateSession(token, userId);
			
		}catch(SessionNotExistException ex){
			
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(Constants.INVALID_SESSION + ex);
			return new ResponseEntity<Object>(errorDTO,HttpStatus.UNAUTHORIZED);
		}
		return object;
		
	}

}
