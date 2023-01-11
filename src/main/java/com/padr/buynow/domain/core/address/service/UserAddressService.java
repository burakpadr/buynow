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
        address.setIsActive(true);

        return userAddressPersistencePort.save(address);
    }

    public UserAddress findUserAddressById(Long id) {
        return userAddressPersistencePort.findById(id).orElseThrow(AddressNotFoundException::new);
    }

    public UserAddress updateUserAddress(Long id, UserAddress updateUserAddress) {
        UserAddress address = findUserAddressById(id);

        address.setAddressName(updateUserAddress.getAddressName());
        address.setCountryName(updateUserAddress.getCountryName());
        address.setStateName(updateUserAddress.getStateName());
        address.setCityName(updateUserAddress.getCityName());
        address.setOpenAddress(updateUserAddress.getOpenAddress());

        return userAddressPersistencePort.save(address);
    }

    public void delete(Long id) {
        UserAddress userAddress = findUserAddressById(id);

        userAddress.setIsActive(false);

        userAddressPersistencePort.save(userAddress);
    }
}
