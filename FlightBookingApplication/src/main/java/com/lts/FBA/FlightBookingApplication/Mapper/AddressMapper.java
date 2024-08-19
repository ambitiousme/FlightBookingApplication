package com.lts.FBA.FlightBookingApplication.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lts.FBA.FlightBookingApplication.DTO.AddressDTO;
import com.lts.FBA.FlightBookingApplication.Entity.Embeded.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

	Address toEntity(AddressDTO addressDTO);

	AddressDTO toDto(Address address);
}
