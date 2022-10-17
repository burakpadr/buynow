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

    public InputFieldType to() {
        return InputFieldType.builder()
                .name(name)
                .build();
    }
}
