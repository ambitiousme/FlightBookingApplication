package com.lts.FBA.FlightBookingApplication.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lts.FBA.FlightBookingApplication.Entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

	@Query("SELECT P FROM Passenger P WHERE P.user.id = :userId")
	List<Passenger> getPassengersByUserId(@Param("userId") Long userId);
	
	@Query("SELECT P FROM Passenger P WHERE P.booking.id = :bookingId")
	List<Passenger> getPassengersByBookingId(@Param("bookingId") Long bookingId);
}
