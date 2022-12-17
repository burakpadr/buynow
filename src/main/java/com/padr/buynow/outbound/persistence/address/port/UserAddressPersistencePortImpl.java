package com.padr.buynow.outbound.persistence.address.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.UserAddress;
import com.padr.buynow.outbound.persistence.address.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserAddressPersistencePortImpl implements UserAddressPersistencePort {

    private final AddressRepository addressRepository;

    @Override
    public Optional<UserAddress> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public UserAddress save(UserAddress address) {
        return addressRepository.save(address);
    }
    
}
