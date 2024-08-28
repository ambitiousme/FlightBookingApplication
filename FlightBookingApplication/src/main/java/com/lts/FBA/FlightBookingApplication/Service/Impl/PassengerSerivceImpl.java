package com.lts.FBA.FlightBookingApplication.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lts.FBA.FlightBookingApplication.DTO.PassengerDTO;
import com.lts.FBA.FlightBookingApplication.Entity.Passenger;
import com.lts.FBA.FlightBookingApplication.Mapper.PassengerMapper;
import com.lts.FBA.FlightBookingApplication.Repository.PassengerRepository;
import com.lts.FBA.FlightBookingApplication.Service.PassengerService;

@Service
public class PassengerSerivceImpl implements PassengerService {

	@Autowired
	private PassengerMapper passengerMapper;

	@Autowired
	private PassengerRepository passengerRepo;

	@Override
	public PassengerDTO addPassenger(PassengerDTO passengerDTO) {

		Passenger passenger = passengerMapper.toEntity(passengerDTO);
		Passenger savedPassenger = passengerRepo.save(passenger);
		return passengerMapper.toDto(savedPassenger);
	}

	@Override
	public Optional<PassengerDTO> getPassengerById(Long passengerId) {
		return passengerRepo.findById(passengerId).map(passenger -> passengerMapper.toDto(passenger));
	}

	@Override
	public Optional<PassengerDTO> updatePassenger(Long passengerId, PassengerDTO passengerDTO) {
		// TODO Auto-generated method stub

		/*
		 * Optional<Passenger> optionalPassenger = passengerRepo.findById(passengerId);
		 * 
		 * if (optionalPassenger.isPresent()) { Passenger existingPassenger =
		 * optionalPassenger.get(); Passenger updatedPassenger =
		 * passengerMapper.toEntity(passengerDTO);
		 * 
		 * updatedPassenger.setId(existingPassenger.getId());
		 * 
		 * updatedPassenger = passengerRepo.save(updatedPassenger);
		 * 
		 * PassengerDTO updatedP_DTO = passengerMapper.toDto(updatedPassenger);
		 * 
		 * return Optional.of(updatedP_DTO);
		 * 
		 * }
		 */
		// return Optional.empty();

		return passengerRepo.findById(passengerId).map(existingPassenger -> {
			Passenger updatedPassenger = passengerMapper.toEntity(passengerDTO);
			updatedPassenger.setId(existingPassenger.getId());
			return passengerMapper.toDto(passengerRepo.save(updatedPassenger));

		});

	}

	@Override
	public Optional<Void> deletePassenger(Long passengerId) {

		Optional<Passenger> opt = passengerRepo.findById(passengerId);
		if (opt.isPresent())
			passengerRepo.delete(opt.get());

		return Optional.empty();

	}

	@Override
	public List<PassengerDTO> getAllPassengers() {
		return passengerRepo.findAll().stream().map(passengerMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public List<PassengerDTO> getPassengersByUserId(Long userId) {
		return passengerRepo.getPassengersByUserId(userId).stream().map(passengerMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<PassengerDTO> getPassengersByBookingId(Long bookingId) {
		return passengerRepo.getPassengersByBookingId(bookingId).stream().map(passengerMapper::toDto)
				.collect(Collectors.toList());
	}

}
