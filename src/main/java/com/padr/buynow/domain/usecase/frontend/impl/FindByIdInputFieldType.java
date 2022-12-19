package com.padr.buynow.domain.usecase.frontend.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindByIdInputFieldType implements BaseUseCase<InputFieldType, Long> {
    
    private final InputFieldTypeService inputFieldTypeService;

    @Override
    public InputFieldType perform(Long id) {
        return inputFieldTypeService.findById(id);
    }
}
