package com.padr.buynow.outbound.persistence.attribute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.attribute.entity.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    
    Optional<Attribute> findByName(String name);
}
