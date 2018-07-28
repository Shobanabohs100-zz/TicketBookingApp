/**
 * 
 */
package com.simple.translator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.simple.dto.TravellerBusDTO;
import com.simple.dto.TravellerDTO;
import com.simple.dto.TravelDTO;
import com.simple.model.Travel;
import com.simple.model.Traveller;
import com.simple.model.TravellerBus;

/**
 * @author suganapa
 *
 */
@Component
public class TicketBookingTranslator {
	
	/**
	 * Method to translate the TravelDTO
	 * 
	 * @param travels, list of travels
	 * @return {@link List<
	 */
	public List<TravelDTO> translateToTravelDTO(List<Travel> travels) {
		
		List<TravelDTO> travelDTOs = new ArrayList<>();
		
		if(travels != null && !travels.isEmpty()) {
			
			for(Travel travel : travels) {
				
				TravelDTO travelDTO = new TravelDTO();
				BeanUtils.copyProperties(travel, travelDTO);
				travelDTOs.add(travelDTO);
			}
		}
		return travelDTOs;
	}
	
	/**
	 * Method to translate the travellerBusDTO
	 * 
	 * @param travellerBusDTO, the object of TravellerBusDTO
	 * @return {@link TravellerBus}
	 */
	public TravellerBus translateTravellerBusDTO(TravellerBusDTO travellerBusDTO) {
		
		TravellerBus travellerBus = new TravellerBus();
		
		if(travellerBusDTO != null) {
			
			BeanUtils.copyProperties(travellerBusDTO, travellerBus);
			List<Traveller> travellers = translateTravellerDTO(travellerBusDTO.getTravellerDTO());
		
			if(travellers != null && !travellers.isEmpty()) {
				travellerBus.setTraveller(travellers);
			}
		}
		return travellerBus;
	}
	
	/**
	 * Method to translate the travellerDTO
	 * 
	 * @param travellerDTOs, list of objects of the TravellerDTO
	 * @return {@link List<Traveller>}
	 */
	public List<Traveller> translateTravellerDTO(List<TravellerDTO> travellerDTOs) {
		
		List<Traveller> travellers = new ArrayList<>();
		
		if(travellerDTOs != null && !travellerDTOs.isEmpty()) {
			
			for(TravellerDTO travellerDTO : travellerDTOs) {
				
				Traveller traveller = new Traveller();
				BeanUtils.copyProperties(travellerDTO, traveller);
				travellers.add(traveller);
			}
		}
		return travellers;
	}

}
