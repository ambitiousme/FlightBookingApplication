package com.lts.FBA.FlightBookingApplication.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lts.FBA.FlightBookingApplication.DTO.RegisterFlightDTO;
import com.lts.FBA.FlightBookingApplication.DTO.SearchFlightDTO;
import com.lts.FBA.FlightBookingApplication.Entity.Flight;

@Mapper(componentModel = "spring")
public interface FlightMapper {

	FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);
	
	Flight toEntity(SearchFlightDTO flightDTO);
	SearchFlightDTO toSearchDTO(Flight flight);
	
	Flight toEntity(RegisterFlightDTO flightDTO);
	RegisterFlightDTO toRegDTO(Flight flight);
	
}
