/**
 * 
 */
package com.simple.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.model.Traveller;

/**
 * @author suganapa
 *
 */
public interface TravellerRepository extends JpaRepository<Traveller, UUID>{

}
