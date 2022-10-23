package com.padr.buynow.inbound.frontend.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.padr.buynow.domain.frontend.entity.InputFieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputFieldTypeRequest {
    
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Boolean hasMultipleValues;

    public InputFieldType to() {
        return InputFieldType.builder()
                .name(name)
                .hasMultipleValues(hasMultipleValues)
                .build();
    }
}
