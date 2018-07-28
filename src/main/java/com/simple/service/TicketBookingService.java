/**
 * 
 */
package com.simple.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.dto.ErrorDTO;
import com.simple.dto.FreeSeatDTO;
import com.simple.dto.LocationDTO;
import com.simple.dto.TravelDTO;
import com.simple.dto.TravellerBusDTO;
import com.simple.dto.TravellerDTO;
import com.simple.enums.TicketStatus;
import com.simple.manager.TicketBookingManager;
import com.simple.model.Location;
import com.simple.model.Travel;
import com.simple.model.Traveller;
import com.simple.model.TravellerBus;
import com.simple.translator.TicketBookingTranslator;
import com.simple.util.Constants;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * @author suganapa
 *
 */
@Component
public class TicketBookingService extends BaseService{
	
	@Autowired
	private TicketBookingManager ticketBookingManager;
	
	@Autowired
	private TicketBookingTranslator tbTranslator;
	
	/**
	 * Method to get all the location based on locationType
	 * 
	 * @param locationType, type of the location
	 * @return {@link LocationDTO}
	 */
	public LocationDTO getAllLocations(String locationType) {
		
		LocationDTO locationDTO = new LocationDTO();
		List<Location> locations = ticketBookingManager.findAllLocations();
		
		if(locationType.equalsIgnoreCase("SOURCE")) {
			
			for(Location location : locations) {
				
				locationDTO.getLocationList().add(location.getSource());
			}
		}else if(locationType.equalsIgnoreCase("DESTINATION")) {
			
			for(Location location : locations) {
				
				locationDTO.getLocationList().add(location.getDestination());
			}
		}
		return locationDTO;
	}
	
	public LocationDTO getAllSourceLocations(String locationType, LocationDTO locationDTO) {
		
		System.out.println("--------getting source-------");
		
		List<Location> locations = ticketBookingManager.findAllLocations();
		
		for(Location location : locations) {
			
			locationDTO.getLocationList().add(location.getSource());
		}
		return locationDTO;
	}
	
	public LocationDTO getAllDestinationLocations(String locationType, LocationDTO locationDTO) {
		
		System.out.println("--------getting destination-------");
		
		List<Location> locations = ticketBookingManager.findAllLocations();
		
		for(Location location : locations) {
			
			locationDTO.getLocationList().add(location.getDestination());
		}
		return locationDTO;
	}
	
	/**
	 * Method to get the dropdown list
	 * 
	 * @param locationType, type of the location
	 * @return {@link LocationDTO}
	 * @throws IOException
	 */
	public LocationDTO getDropdownList(String locationType) throws IOException {
		Element elementAdd = null; 
		Element element = null;
		Cache cache = null;
		LocationDTO dropdownList = null;
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocationList(new ArrayList<>());
		try {
			cache =getCacheManager().getCache("getDropdownList"); //cache name mentioned in ehcache.xml
			element = cache.get(locationType);
			if(element==null) { // get values from API if doesn’t exists in Cache
				dropdownList = getAllSourceLocations(locationType, locationDTO);
				cache.put(new Element(locationType, dropdownList));
				return dropdownList;
			}
		} catch (Exception e) {
			throw e; 
		}
		locationDTO = (LocationDTO) element.getObjectValue();
		return locationDTO;
	}

	
	/**
	 * Method to get travels by source, destination, travel date
	 * 
	 * @param source, the source from which the trip starts
	 * @param dest, the destination where the trip ends
	 * @param tvlDate, date of the trip
	 * @return{@link List<TravelDTO}
	 */
	public Object getTravelsBySourceAndDestAndDate(String source, String dest, String tvlDate) {
		
		List<Travel> travels = new ArrayList<>();
		if(source != null && dest != null && tvlDate != null) {
			try{
			travels = ticketBookingManager.findTravelsBySourceAndDestAndDate(source, dest, tvlDate);
			
			}catch(DataAccessResourceFailureException ex) {
				
				ErrorDTO errorDTO = new ErrorDTO();
				errorDTO.setMessage(Constants.DB_CONNECTION_ERROR);
				return errorDTO;
				
			}catch(Exception ex) {
				
				ErrorDTO errorDTO = new ErrorDTO();
				errorDTO.setMessage(ex.getMessage());
				return errorDTO;
			}
		}
		List<TravelDTO> travelDTOs = new ArrayList<>();
		
		if(travels != null && !travels.isEmpty()) {
			
			travelDTOs = tbTranslator.translateToTravelDTO(travels);
		}
		return travelDTOs;
	}
	
	/**
	 * Method to get the free seats by travelId
	 * 
	 * @param travelId, primary Id of the travel
	 */
	public Object getFreeSeatsByTravelId(String travelId) {
		
		Travel travel = ticketBookingManager.findTravelByIdAndIsActiveTrue(travelId);
		FreeSeatDTO freeSeatDTO = new FreeSeatDTO();
		
		if(travel != null) {
			
			ObjectMapper mapper = new ObjectMapper();
			try {
				freeSeatDTO = new ObjectMapper().readValue(travel.getFreeSeat(), FreeSeatDTO.class);
			} catch (IOException e) {
				ErrorDTO errorDTO = new ErrorDTO();
				errorDTO.setMessage("Can't map the json to the DTO");
				return errorDTO;
			}
		}
		return freeSeatDTO;
	}
	
	/**
	 * Method to book seats
	 * 
	 * @param travellerBusDTO, the object of TravellerBusDTO
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Transactional
	public void bookingSeats(TravellerBusDTO travellerBusDTO) throws JsonParseException, JsonMappingException, IOException {
		
		TravellerBus travellerBus = tbTranslator.translateTravellerBusDTO(travellerBusDTO);
		
		Travel travel = ticketBookingManager.findTravelByIdAndIsActiveTrue(travellerBus.getTravelId());
		
		if(travel != null) {
			
			ObjectMapper objectMapper = new ObjectMapper();
			travel.setAvailableSeat(travel.getAvailableSeat()-travellerBusDTO.getTravellerDTO().size());
			FreeSeatDTO freeSeatDTO =objectMapper.readValue(travel.getFreeSeat(), FreeSeatDTO.class);
			
			if(freeSeatDTO != null && travellerBusDTO.getTravellerDTO() != null) {
				
				for(TravellerDTO travellerDTO : travellerBusDTO.getTravellerDTO()) {
					freeSeatDTO.getSeats().remove(travellerDTO.getSeatNo());
				}

				travel.setFreeSeat(objectMapper.writeValueAsString(freeSeatDTO));
			}
			ticketBookingManager.saveTravel(travel);
		}
		ticketBookingManager.saveTraveller(travellerBus.getTraveller());
		ticketBookingManager.saveTravellerBus(travellerBus);
	}
	
	public void cancelSeats(String bookingId, FreeSeatDTO travellerDTO) throws JsonParseException, JsonMappingException, IOException {
		
		TravellerBus travellerBus = ticketBookingManager.findByTravellerBusId(bookingId);
		
		if(travellerBus != null) {
			
			List<String> seats = new ArrayList<>();
			
			List<Traveller> travellers = travellerBus.getTraveller();
			if(travellers != null && !travellers.isEmpty()) {
				
				for(Traveller traveller : travellers) {
					if(travellerDTO.getSeats().contains(traveller.getId())) {
						seats.add(traveller.getSeatNo());
						traveller.setStatus(TicketStatus.CANCELLED.toString());
					}
				}
				Travel travel = ticketBookingManager.findTravelByIdAndIsActiveTrue(travellerBus.getTravelId());
				if(travel !=null) {
					travel.setAvailableSeat(travel.getAvailableSeat() + travellerDTO.getSeats().size());
					FreeSeatDTO freeSeatDTO =new ObjectMapper().readValue(travel.getFreeSeat(), FreeSeatDTO.class);
					freeSeatDTO.getSeats().addAll(seats);
					travel.setFreeSeat(new ObjectMapper().writeValueAsString(freeSeatDTO));
					ticketBookingManager.saveTravel(travel);
				}
				ticketBookingManager.saveTraveller(travellers);
			}
			
		}else {
			
			//throw new ObjectNotFoundException("Invalid Booking Id");
		}
		
	}
}
