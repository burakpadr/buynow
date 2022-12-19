package com.padr.buynow.domain.usecase.frontend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateInputFieldTypeModel {
    
    private Long id;
    private InputFieldTypeModel updateInputFieldTypeModel;
}
