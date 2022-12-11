package com.padr.buynow.domain.usecase.frontend.inputfieldtype.model;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateInputFieldTypeUseCaseModel {
    
    private Long id;
    private InputFieldType inputFieldType;
}
