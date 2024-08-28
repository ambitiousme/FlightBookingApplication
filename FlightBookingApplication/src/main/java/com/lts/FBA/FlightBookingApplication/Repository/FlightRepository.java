package com.lts.FBA.FlightBookingApplication.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lts.FBA.FlightBookingApplication.Entity.Airline;
import com.lts.FBA.FlightBookingApplication.Entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("SELECT f FROM Flight f WHERE f.source = :flightFrom AND f.destination = :flightTo AND FUNCTION('DATE',f.departureTime) = :flightDate")
	List<Flight> findFlightsBySourceDestinationAndFlightDate(@Param("flightFrom") String flightFrom,
			@Param("flightTo") String flightTo, @Param("flightDate") LocalDate flightDate);

	Optional<Flight> findByFlightNumber(String flightNumber);
	Optional<Flight> deleteByFlightNumber(String flightNumber);
}
