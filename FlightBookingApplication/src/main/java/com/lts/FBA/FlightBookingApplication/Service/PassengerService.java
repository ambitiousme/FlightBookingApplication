package com.lts.FBA.FlightBookingApplication.Service;

import java.util.List;
import java.util.Optional;

import com.lts.FBA.FlightBookingApplication.DTO.PassengerDTO;

public interface PassengerService {

	PassengerDTO addPassenger(PassengerDTO passengerDTO);

	Optional<PassengerDTO> getPassengerById(Long passengerId);

	Optional<PassengerDTO> updatePassenger(Long passengerId, PassengerDTO passengerDTO);

	Optional<Void> deletePassenger(Long passengerId);

	List<PassengerDTO> getAllPassengers();
	
	List<PassengerDTO> getPassengersByUserId(Long userId);
	
	List<PassengerDTO> getPassengersByBookingId(Long bookingId);
	

}
