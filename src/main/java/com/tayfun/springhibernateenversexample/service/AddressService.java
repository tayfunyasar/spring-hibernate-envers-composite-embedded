package com.tayfun.springhibernateenversexample.service;

import com.tayfun.springhibernateenversexample.dto.AddressDTO;
import com.tayfun.springhibernateenversexample.dto.request.AddressRequest;
import java.util.List;

public interface AddressService {

    List<AddressDTO> getAll();

    AddressDTO getById(Long id);

    AddressDTO create(AddressRequest addressRequest);

    AddressDTO update(AddressRequest addressRequest);

    void delete(Long id);
}
