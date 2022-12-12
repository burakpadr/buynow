package com.padr.buynow.domain.usecase.frontend.inputfieldtype.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateInputFieldTypeUseCaseRequest {
    
    private Long id;
    private InputFieldTypeUseCaseRequest updateInputFieldType;
}
