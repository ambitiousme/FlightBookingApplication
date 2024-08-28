package com.lts.FBA.FlightBookingApplication.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lts.FBA.FlightBookingApplication.DTO.PassengerDTO;
import com.lts.FBA.FlightBookingApplication.Entity.Passenger;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

	PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

	Passenger toEntity(PassengerDTO passengerDTO);

	PassengerDTO toDto(Passenger passenger);
}
