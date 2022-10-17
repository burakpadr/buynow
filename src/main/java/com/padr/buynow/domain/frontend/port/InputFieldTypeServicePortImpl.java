package com.padr.buynow.domain.frontend.port;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.frontend.entity.InputFieldType;
import com.padr.buynow.domain.frontend.service.InputFieldTypeService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InputFieldTypeServicePortImpl implements InputFieldTypeServicePort {
    
    private final InputFieldTypeService inputFieldTypeService;

    @Override
    public InputFieldType create(InputFieldType inputFieldType) {
        return inputFieldTypeService.create(inputFieldType);
    }

    @Override
    public InputFieldType findById(Long id) {
        return inputFieldTypeService.findById(id);
    }

    @Override
    public InputFieldType findByName(String name) {
        return inputFieldTypeService.findByName(name);
    }

    @Override
    public InputFieldType update(Long id, InputFieldType updateInputFieldType) {
        return inputFieldTypeService.update(id, updateInputFieldType);
    }

    @Override
    public void deleteById(Long id) {
        inputFieldTypeService.deleteById(id);
    }
}
