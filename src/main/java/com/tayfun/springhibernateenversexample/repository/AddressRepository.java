package com.tayfun.springhibernateenversexample.repository;

import com.tayfun.springhibernateenversexample.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
