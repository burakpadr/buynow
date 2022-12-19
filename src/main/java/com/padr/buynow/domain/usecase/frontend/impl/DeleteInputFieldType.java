package com.padr.buynow.domain.usecase.frontend.impl;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteInputFieldType implements BaseUseCase<Void, Long> {

    private final InputFieldTypeService inputFieldTypeService;

    @Override
    public Void perform(Long id) {
        inputFieldTypeService.deleteById(id);

        return null;
    }
}
