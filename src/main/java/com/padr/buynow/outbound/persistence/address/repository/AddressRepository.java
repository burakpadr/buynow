package com.padr.buynow.outbound.persistence.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padr.buynow.domain.core.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
