package com.padr.buynow.domain.usecase.frontend.inputfieldtype.model;

import com.padr.buynow.domain.core.frontend.entity.InputFieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputFieldTypeUseCaseModel {
    
    private String name;
    private Boolean hasMultipleValue;

    public InputFieldType to() {
        return InputFieldType.builder()
                .name(name)
                .hasMultipleValue(hasMultipleValue)
                .build();
    }
}
