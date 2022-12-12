package com.padr.buynow.domain.usecase.frontend.inputfieldtype.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateInputFieldTypeUseCaseModel {
    
    private Long id;
    private InputFieldTypeUseCaseModel updateInputFieldTypeModel;
}
