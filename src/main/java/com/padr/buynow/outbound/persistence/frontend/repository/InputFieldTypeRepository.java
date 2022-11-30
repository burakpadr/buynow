package com.padr.buynow.outbound.persistence.frontend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;

@Repository
public interface InputFieldTypeRepository extends JpaRepository<InputFieldType, Long> {
    
    Optional<InputFieldType> findByName(String name);
}
