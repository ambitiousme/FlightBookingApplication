package com.lts.FBA.FlightBookingApplication.Service;

import java.util.List;
import com.lts.FBA.FlightBookingApplication.DTO.FlightSeatDTO;



public interface FlightSeatService {

	List<FlightSeatDTO> assignSeatsForFlight(List<FlightSeatDTO> seats);
	
	void deleteByFlightId(Long flightId);
	
}
