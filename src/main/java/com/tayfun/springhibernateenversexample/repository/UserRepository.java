package com.tayfun.springhibernateenversexample.repository;

import com.tayfun.springhibernateenversexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
