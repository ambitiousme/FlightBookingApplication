package com.lts.FBA.FlightBookingApplication.Mapper;

import com.lts.FBA.FlightBookingApplication.Entity.AirlineSeat;
import com.lts.FBA.FlightBookingApplication.Entity.Flight;
import com.lts.FBA.FlightBookingApplication.Entity.FlightSeat;

public class AirlineSeatToFlightSeatMapper {

	public static void airlineToFlightSeat(AirlineSeat airlineSeat, FlightSeat flightSeat, Flight savedFlight) {

		flightSeat.setAirline_id(airlineSeat.getAirline().getId());
		flightSeat.setId(airlineSeat.getId());
		flightSeat.setClassType(airlineSeat.getClassType());
		flightSeat.setSeatNumber(airlineSeat.getSeatNumber());
		flightSeat.setFlight(savedFlight);
		flightSeat.setAvailability(true);
	}

}
