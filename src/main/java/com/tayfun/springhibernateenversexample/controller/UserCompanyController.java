package com.tayfun.springhibernateenversexample.controller;

import com.tayfun.springhibernateenversexample.dto.UserDTO;
import com.tayfun.springhibernateenversexample.dto.request.UserRequest;
import com.tayfun.springhibernateenversexample.model.UserCompanyRole;
import com.tayfun.springhibernateenversexample.model.UserCompanyRoleId;
import com.tayfun.springhibernateenversexample.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class UserCompanyController {

    private final UserService userService;

    public UserCompanyController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserRequest request) {
        UserCompanyRole userCompanyRole = new UserCompanyRole();

        UserCompanyRoleId userCompanyRoleId = new UserCompanyRoleId();
        userCompanyRoleId.setCompanyId(1L);
        userCompanyRoleId.setRole("role");
        userCompanyRole.setUserCompanyRoleId(userCompanyRoleId);

        UserDTO userDTO = userService.create(request, userCompanyRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping()
    public ResponseEntity<UserDTO> update(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
