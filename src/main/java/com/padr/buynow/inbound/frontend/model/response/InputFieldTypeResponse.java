package com.padr.buynow.inbound.frontend.model.response;

import com.padr.buynow.domain.frontend.entity.InputFieldType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputFieldTypeResponse {
    
    private Long id;
    private String name;
    private Boolean isActive;

    public static InputFieldTypeResponse of(InputFieldType inputFieldType) {
        return InputFieldTypeResponse.builder()
                .id(inputFieldType.getId())
                .name(inputFieldType.getName())
                .isActive(inputFieldType.getIsActive())
                .build();
    } 
}
