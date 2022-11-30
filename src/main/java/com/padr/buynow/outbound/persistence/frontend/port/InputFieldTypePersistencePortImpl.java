package com.padr.buynow.outbound.persistence.frontend.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.outbound.persistence.frontend.repository.InputFieldTypeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InputFieldTypePersistencePortImpl implements InputFieldTypePersistencePort {
    
    private final InputFieldTypeRepository inputFieldTypeRepository;

    @Override
    public Optional<InputFieldType> findById(Long id) {
        return inputFieldTypeRepository.findById(id);
    }

    @Override
    public Optional<InputFieldType> findByName(String name) {
        return inputFieldTypeRepository.findByName(name);
    }

    @Override
    public InputFieldType save(InputFieldType inputFieldType) {
        return inputFieldTypeRepository.save(inputFieldType);
    }
}
