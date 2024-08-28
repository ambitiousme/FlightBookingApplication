package com.lts.FBA.FlightBookingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lts.FBA.FlightBookingApplication.Entity.FlightSeat;



@Repository
public interface FlightSeatsRepository extends JpaRepository<FlightSeat, Long> {
	
	@Modifying
	@Query("DELETE FROM FlightSeat FS WHERE FS.flight.id =:flightId")
	void deleteByFlightId(@Param("flightId") Long flightId);

}
