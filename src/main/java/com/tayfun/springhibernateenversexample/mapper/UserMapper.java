package com.tayfun.springhibernateenversexample.mapper;

import com.tayfun.springhibernateenversexample.dto.UserDTO;
import com.tayfun.springhibernateenversexample.dto.request.UserRequest;
import com.tayfun.springhibernateenversexample.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userRequestToUser(UserRequest userRequest);

    UserDTO userToUserDTO(User user);

    UserDTO userToUserDTONullUserIdUsername(User user);
}
