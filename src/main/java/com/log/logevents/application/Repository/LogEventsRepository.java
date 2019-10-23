package com.log.logevents.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.log.logevents.application.Model.EventDetails;

/**
 * 
 * @author Akansha Karwa
 *
 */
public interface LogEventsRepository extends JpaRepository<EventDetails, String>{

}
