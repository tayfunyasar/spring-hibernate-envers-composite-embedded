package com.tayfun.springhibernateenversexample.service;

import com.tayfun.springhibernateenversexample.dto.UserDTO;
import com.tayfun.springhibernateenversexample.dto.request.UserRequest;
import com.tayfun.springhibernateenversexample.mapper.UserMapper;
import com.tayfun.springhibernateenversexample.model.User;
import com.tayfun.springhibernateenversexample.model.UserCompanyRole;
import com.tayfun.springhibernateenversexample.repository.UserCompanyRoleRepository;
import com.tayfun.springhibernateenversexample.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCompanyRoleRepository userCompanyRoleRepository;
    private final EntityManager entityManager;

    public UserServiceImpl(UserRepository userRepository, UserCompanyRoleRepository userCompanyRoleRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.userCompanyRoleRepository = userCompanyRoleRepository;
        this.entityManager = entityManager;
    }

    public UserDTO create(UserRequest userRequest, UserCompanyRole userCompanyRole) {
        User user = UserMapper.INSTANCE.userRequestToUser(userRequest);
        user = userRepository.save(user);

        userCompanyRole.getUserCompanyRoleId().setUserId(user.getId());
        user.setUserCompanyRoles(List.of(userCompanyRole));
        userCompanyRoleRepository.save(userCompanyRole);
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
            .map(UserMapper.INSTANCE::userToUserDTONullUserIdUsername)
            .collect(Collectors.toList());
    }

    public UserDTO update(UserRequest userRequest) {
        User user = findUserById(userRequest.getId());

        UserCompanyRole userCompanyRole = user.getUserCompanyRoles().get(0);
        userCompanyRole.getUserCompanyRoleId().setRole("role3");

        // userCompanyRoleRepository.save(userCompanyRole);

        user.getUserCompanyRoles().clear();
        user.getUserCompanyRoles().add(userCompanyRole);

        var savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(savedUser);
    }

    public UserDTO getById(Long id) {
        User user = findUserById(id);
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public User findUserById(Long id) {
        return userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    
}
