package com.padr.buynow.domain.usecase.frontend.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.frontend.model.UpdateInputFieldTypeModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateInputFieldType implements BaseUseCase<InputFieldType, UpdateInputFieldTypeModel> {

    private final InputFieldTypeService inputFieldTypeService;

    @Override
    public InputFieldType perform(UpdateInputFieldTypeModel updateInputFieldTypeUseCaseModel) {
        return inputFieldTypeService.update(updateInputFieldTypeUseCaseModel.getId(),
                updateInputFieldTypeUseCaseModel.getUpdateInputFieldTypeModel().to());
    }

}
