package com.padr.buynow.domain.usecase.frontend.inputfieldtype.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;
import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.frontend.inputfieldtype.model.request.InputFieldTypeUseCaseRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateInputFieldTypeUseCase implements BaseUseCase<InputFieldType, InputFieldTypeUseCaseRequest> {

    private final InputFieldTypeService inputFieldTypeService;

    @Override
    public InputFieldType perform(InputFieldTypeUseCaseRequest inputFielFieldTypeUseCaseRequest) {
        return inputFieldTypeService.create(inputFielFieldTypeUseCaseRequest.to());
    }

}
