package com.padr.buynow.outbound.persistence.address.port;

import java.util.Optional;

import com.padr.buynow.domain.address.entity.Address;

public interface AddressPersistencePort {
    
    Optional<Address> findById(Long id);

    Address save(Address address);
}
