package com.padr.buynow.domain.usecase.frontend.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.frontend.model.CreateInputFieldTypeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateInputFieldType implements BaseUseCase<InputFieldType, CreateInputFieldTypeModel> {

    private final InputFieldTypeService inputFieldTypeService;

    @Override
    public InputFieldType perform(CreateInputFieldTypeModel inputFielFieldTypeUseCaseModel) {
        return inputFieldTypeService.create(inputFielFieldTypeUseCaseModel.to());
    }

}
