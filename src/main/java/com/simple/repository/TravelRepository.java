/**
 * 
 */
package com.simple.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.simple.model.Location;
import com.simple.model.Travel;

/**
 * @author suganapa
 *
 */
@Component
public interface TravelRepository extends JpaRepository<Travel, UUID>{
	
	@Query("Select travel from Travel travel join travel.location loc where loc.source = :source"
			+ " and loc.destination = :dest and travel.tvlDate = :tvlDate and loc.isActive = true and travel.isActive = true")
	public List<Travel> findBySourceAndDestAndDate(@Param("source") String source,@Param("dest") String dest,@Param("tvlDate") String tvlDate);

	public Travel findByIdAndIsActiveTrue(String id);
}
