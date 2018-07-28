/**
 * 
 */
package com.simple.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.simple.model.Location;

/**
 * @author suganapa
 *
 */
@Component
public interface LocationRepository extends JpaRepository<Location, UUID> {
	
	public List<Location> findAllByIsActiveTrue();

}
