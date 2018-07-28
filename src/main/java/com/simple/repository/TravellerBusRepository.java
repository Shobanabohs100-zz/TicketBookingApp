/**
 * 
 */
package com.simple.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.model.Location;
import com.simple.model.TravellerBus;

/**
 * @author suganapa
 *
 */
public interface TravellerBusRepository extends JpaRepository<TravellerBus, UUID> {
	
	public TravellerBus findByIdAndIsActiveTrue(String id);

}
