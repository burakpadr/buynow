package com.padr.buynow.domain.core.address.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.address.entity.UserAddress;
import com.padr.buynow.domain.core.address.exception.AddressNotFoundException;
import com.padr.buynow.outbound.persistence.address.port.UserAddressPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAddressService {
    
    private final UserAddressPersistencePort userAddressPersistencePort;

    public UserAddress createUserAddress(UserAddress address) {
        return userAddressPersistencePort.save(address);
    }

    public UserAddress findUserAddressById(Long id) {
        return userAddressPersistencePort.findById(id).orElseThrow(AddressNotFoundException::new);
    }

    public UserAddress updateUserAddress(Long id, UserAddress updateUserAddress) {
        UserAddress address = findUserAddressById(id);

        address.setCountryName(updateUserAddress.getCountryName());
        address.setStateName(updateUserAddress.getStateName());
        address.setCityName(updateUserAddress.getCityName());

        return userAddressPersistencePort.save(address);
    }
}
