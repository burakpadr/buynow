package com.padr.buynow.domain.usecase.frontend.inputfieldtype.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateInputFieldTypeUseCase implements BaseUseCase<InputFieldType, InputFieldType> {

    private final InputFieldTypeService inputFieldTypeService;

    @Override
    public InputFieldType perform(InputFieldType inputFieldType) {
        return inputFieldTypeService.create(inputFieldType);
    }

}
