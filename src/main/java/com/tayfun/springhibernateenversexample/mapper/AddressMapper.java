package com.tayfun.springhibernateenversexample.mapper;

import com.tayfun.springhibernateenversexample.dto.AddressDTO;
import com.tayfun.springhibernateenversexample.dto.request.AddressRequest;
import com.tayfun.springhibernateenversexample.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "userId", target = "user.id")
    Address addressRequestToAddress(AddressRequest addressRequest);

    @Named("addressToAddressDTO")
    @Mapping(source = "user.id", target = "userId")
    AddressDTO addressToAddressDTO(Address address);
}
