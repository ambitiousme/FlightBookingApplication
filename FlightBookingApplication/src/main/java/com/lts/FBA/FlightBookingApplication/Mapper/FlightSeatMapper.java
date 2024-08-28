package com.lts.FBA.FlightBookingApplication.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lts.FBA.FlightBookingApplication.DTO.FlightSeatDTO;
import com.lts.FBA.FlightBookingApplication.Entity.FlightSeat;


@Mapper(componentModel = "spring")
public interface FlightSeatMapper {
	
	FlightSeatMapper INSTANCE = Mappers.getMapper(FlightSeatMapper.class);
	
	FlightSeat toEntity(FlightSeatDTO seatDTO);
	FlightSeatDTO toDTO (FlightSeat seat);
	
}
