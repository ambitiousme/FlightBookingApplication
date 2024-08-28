package com.lts.FBA.FlightBookingApplication.Repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lts.FBA.FlightBookingApplication.Entity.AirlineSeat;

@Repository
public interface AirlineSeatRepostiory extends JpaRepository<AirlineSeat, Long> {

	@Query("SELECT s FROM AirlineSeat s WHERE s.airline.id = :id")
	List<AirlineSeat> findSeatsById(@Param ("id") Long id);
}
