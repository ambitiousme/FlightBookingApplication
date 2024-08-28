package com.lts.FBA.FlightBookingApplication.Mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lts.FBA.FlightBookingApplication.Entity.AirlineSeat;
import com.lts.FBA.FlightBookingApplication.Entity.Flight;
import com.lts.FBA.FlightBookingApplication.Entity.FlightSeat;
import com.lts.FBA.FlightBookingApplication.Service.Impl.FlightServiceImpl;

public class AirlineSeatToFlightSeatMapper {

	private static final Logger log = LoggerFactory.getLogger(AirlineSeatToFlightSeatMapper.class);
	public static void airlineToFlightSeat(AirlineSeat airlineSeat, FlightSeat flightSeat, Flight savedFlight) {

		
		
		flightSeat.setAirline_id(airlineSeat.getAirline().getId());
		flightSeat.setId(airlineSeat.getId());
		flightSeat.setClassType(airlineSeat.getClassType());
		flightSeat.setSeatNumber(airlineSeat.getSeatNumber());
		//log.debug("savedFlight.getId : "+ flightSeat.getId());
		flightSeat.setFlight(savedFlight);
		//log.debug("savedFlight.getId : "+ flightSeat.getFlight());
		flightSeat.setAvailability(true);
	}

}
