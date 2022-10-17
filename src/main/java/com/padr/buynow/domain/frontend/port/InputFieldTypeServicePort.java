package com.padr.buynow.domain.frontend.port;

import com.padr.buynow.domain.frontend.entity.InputFieldType;

public interface InputFieldTypeServicePort {
    
    InputFieldType create(InputFieldType inputFieldType);

    InputFieldType findById(Long id);

    InputFieldType findByName(String name);

    InputFieldType update(Long id, InputFieldType updateInputFieldType);

    void deleteById(Long id);
}
