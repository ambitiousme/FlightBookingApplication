package com.lts.FBA.FlightBookingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lts.FBA.FlightBookingApplication.Entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>{

}
