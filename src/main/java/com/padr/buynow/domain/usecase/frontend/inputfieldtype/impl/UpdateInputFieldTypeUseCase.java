package com.padr.buynow.domain.usecase.frontend.inputfieldtype.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.frontend.inputfieldtype.model.UpdateInputFieldTypeUseCaseModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateInputFieldTypeUseCase implements BaseUseCase<InputFieldType, UpdateInputFieldTypeUseCaseModel> {

    private final InputFieldTypeService inputFieldTypeService;

    @Override
    public InputFieldType perform(UpdateInputFieldTypeUseCaseModel updateInputFieldTypeUseCaseModel) {
        return inputFieldTypeService.update(updateInputFieldTypeUseCaseModel.getId(),
                updateInputFieldTypeUseCaseModel.getInputFieldType());
    }

}
