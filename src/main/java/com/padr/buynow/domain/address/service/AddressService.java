package com.padr.buynow.domain.address.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.Address;
import com.padr.buynow.domain.address.exception.AddressNotFoundException;
import com.padr.buynow.outbound.persistence.address.port.AddressPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
    
    private final AddressPersistencePort addressPersistencePort;

    public Address createAddress(Address address) {
        return addressPersistencePort.save(address);
    }

    public Address findAddressById(Long id) {
        return addressPersistencePort.findById(id).orElseThrow(AddressNotFoundException::new);
    }

    public Address updateAddress(Long id, Address updateAddress) {
        Address address = findAddressById(id);

        address.setCountryName(updateAddress.getCountryName());
        address.setStateName(updateAddress.getStateName());
        address.setCityName(updateAddress.getCityName());

        return addressPersistencePort.save(address);
    }
}
