package com.lts.FBA.FlightBookingApplication.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lts.FBA.FlightBookingApplication.DTO.FlightSeatDTO;



public interface FlightSeatService {

	List<FlightSeatDTO> assignSeatsForFlight(List<FlightSeatDTO> seats);
	
	@Transactional
	void deleteByFlightId(Long flightId);
	
}
