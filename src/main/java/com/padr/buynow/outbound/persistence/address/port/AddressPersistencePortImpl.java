package com.padr.buynow.outbound.persistence.address.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.address.entity.Address;
import com.padr.buynow.outbound.persistence.address.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AddressPersistencePortImpl implements AddressPersistencePort {

    private final AddressRepository addressRepository;

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
    
}
