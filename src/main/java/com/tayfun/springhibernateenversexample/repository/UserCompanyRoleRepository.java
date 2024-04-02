package com.tayfun.springhibernateenversexample.repository;

import com.tayfun.springhibernateenversexample.model.UserCompanyRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCompanyRoleRepository extends JpaRepository<UserCompanyRole, Long> {

}
