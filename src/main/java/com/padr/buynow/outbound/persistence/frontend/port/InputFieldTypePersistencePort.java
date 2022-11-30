package com.padr.buynow.outbound.persistence.frontend.port;

import java.util.Optional;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;

public interface InputFieldTypePersistencePort {
    
    Optional<InputFieldType> findById(Long id);

    Optional<InputFieldType> findByName(String name);

    InputFieldType save(InputFieldType inputFieldType);
}
