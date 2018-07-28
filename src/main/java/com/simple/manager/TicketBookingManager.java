/**
 * 
 */
package com.simple.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simple.model.Location;
import com.simple.model.Travel;
import com.simple.model.Traveller;
import com.simple.model.TravellerBus;
import com.simple.repository.LocationRepository;
import com.simple.repository.TravelRepository;
import com.simple.repository.TravellerBusRepository;
import com.simple.repository.TravellerRepository;

/**
 * @author suganapa
 *
 */
@Component
public class TicketBookingManager {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private TravelRepository travelRepository;
	
	@Autowired
	private TravellerBusRepository tvBusRepository;
	
	@Autowired
	private TravellerRepository travellerRepository;
	
	/**
	 * Method to find all the existing location
	 * 
	 * @return{@link List<Location}
	 */
	public List<Location> findAllLocations() {
		return locationRepository.findAll();
	}
	
	/**
	 * Method to find travels by source, destination and date
	 * 
	 * @param source, the source from which the trip starts
	 * @param dest, the destination where the trip ends
	 * @param tvlDate, date of the trip
	 * @return{@link List<TravelDTO>}
	 */
	public List<Travel> findTravelsBySourceAndDestAndDate(String source, String dest, String tvlDate) {
		return travelRepository.findBySourceAndDestAndDate(source, dest, tvlDate);
	}
	
	/**
	 * Method to find travel by its Id
	 * 
	 * @param travelId, primary Id of the trave
	 * @return {@link TravelDTO}
	 */
	public Travel findTravelByIdAndIsActiveTrue(String travelId) {
		return travelRepository.findByIdAndIsActiveTrue(travelId);
	}
	
	/**
	 * Method to save the traveller bus
	 * 
	 * @param travellerBus, the object of TravellerBus
	 * @return {@link TravellerBus}
	 */
	public TravellerBus saveTravellerBus(TravellerBus travellerBus) {
		return tvBusRepository.save(travellerBus);
	}
	
	/**
	 * Method to save traveller list
	 * 
	 * @param traveller, the object of List<Traveller>
	 * @return {@link List<Traveller>}
	 */
	public List<Traveller> saveTraveller(List<Traveller> travellers) {
		return travellerRepository.save(travellers);
	}
	
	/**
	 * Method to save the travel
	 * 
	 * @param travel, the object of Travel to be saved
	 * @return {@link Travel}
	 */
	public Travel saveTravel(Travel travel) {
		return travelRepository.save(travel);
	}
	
	public TravellerBus findByTravellerBusId(String bookingId) {
		return tvBusRepository.findByIdAndIsActiveTrue(bookingId);
	}
}
