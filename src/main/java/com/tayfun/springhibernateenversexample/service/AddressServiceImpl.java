package com.tayfun.springhibernateenversexample.service;

import com.tayfun.springhibernateenversexample.dto.AddressDTO;
import com.tayfun.springhibernateenversexample.dto.request.AddressRequest;
import com.tayfun.springhibernateenversexample.mapper.AddressMapper;
import com.tayfun.springhibernateenversexample.model.Address;
import com.tayfun.springhibernateenversexample.model.User;
import com.tayfun.springhibernateenversexample.repository.AddressRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserServiceImpl userService;

    public AddressServiceImpl(
        AddressRepository addressRepository, UserServiceImpl userService) {
        this.addressRepository = addressRepository;
        this.userService = userService;
    }

    public List<AddressDTO> getAll() {
        return addressRepository.findAll().stream()
            .map(AddressMapper.INSTANCE::addressToAddressDTO)
            .collect(Collectors.toList());
    }

    public AddressDTO getById(Long id) {
        Address address = findAddressById(id);
        return AddressMapper.INSTANCE.addressToAddressDTO(address);
    }

    public AddressDTO create(AddressRequest addressRequest) {
        User user = userService.findUserById(addressRequest.getUserId());
        Address address = AddressMapper.INSTANCE.addressRequestToAddress(addressRequest);
        address.setUser(user);
        address = addressRepository.save(address);
        return AddressMapper.INSTANCE.addressToAddressDTO(address);
    }

    public AddressDTO update(AddressRequest addressRequest) {
        Address address = findAddressById(addressRequest.getId());
        Address updatedAddress = AddressMapper.INSTANCE.addressRequestToAddress(addressRequest);
        BeanUtils.copyProperties(updatedAddress, address, "id", "user");
        addressRepository.save(address);
        return AddressMapper.INSTANCE.addressToAddressDTO(address);
    }

    public void delete(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
        } else {
            throw new RuntimeException("Address not found with id: " + id);
        }
    }

    private Address findAddressById(Long id) {
        return addressRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException(("Address not found with id: " + id)));
    }

}
