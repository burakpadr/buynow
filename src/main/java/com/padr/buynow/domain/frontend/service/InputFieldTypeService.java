package com.padr.buynow.domain.frontend.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.frontend.entity.InputFieldType;
import com.padr.buynow.domain.frontend.exception.InputFieldTypeAlreadyExistWithNameException;
import com.padr.buynow.domain.frontend.exception.InputFieldTypeNotFoundException;
import com.padr.buynow.outbound.persistence.frontend.port.InputFieldTypePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InputFieldTypeService {
    
    private final InputFieldTypePersistencePort inputFieldTypePersistencePort;

    public InputFieldType create(InputFieldType inputFieldType) {
        inputFieldType.setIsActive(true);

        return inputFieldTypePersistencePort.save(inputFieldType);
    }

    public InputFieldType findById(Long id) {
        return inputFieldTypePersistencePort.findById(id).orElseThrow(InputFieldTypeNotFoundException::new);
    }

    public InputFieldType findByName(String name) {
        return inputFieldTypePersistencePort.findByName(name).orElseThrow(InputFieldTypeNotFoundException::new);
    }

    public InputFieldType update(Long id, InputFieldType updateInputFieldType) {
        InputFieldType inputFieldType = findById(id);

        inputFieldTypePersistencePort.findByName(updateInputFieldType.getName()).ifPresent(ift -> {
            if (ift.getId() != inputFieldType.getId())
                throw new InputFieldTypeAlreadyExistWithNameException(); 
        });

        inputFieldType.setName(updateInputFieldType.getName());

        return inputFieldTypePersistencePort.save(inputFieldType);
    } 

    public void deleteById(Long id) {
        InputFieldType inputFieldType = findById(id);

        inputFieldType.setIsActive(false);

        inputFieldTypePersistencePort.save(inputFieldType);
    }
}
