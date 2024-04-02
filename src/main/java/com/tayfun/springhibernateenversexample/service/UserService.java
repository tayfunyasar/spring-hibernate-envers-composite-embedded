package com.tayfun.springhibernateenversexample.service;

import com.tayfun.springhibernateenversexample.dto.UserDTO;
import com.tayfun.springhibernateenversexample.dto.request.UserRequest;
import com.tayfun.springhibernateenversexample.model.User;
import com.tayfun.springhibernateenversexample.model.UserCompanyRole;
import java.util.List;

public interface UserService {

    UserDTO create(UserRequest userRequest, UserCompanyRole userCompanyRole);

    List<UserDTO> getAll();

    UserDTO update(UserRequest userRequest);

    UserDTO getById(Long id);

    void delete(Long id);

    User findUserById(Long id);
}
