package com.padr.buynow.domain.attribute.port;

import com.padr.buynow.domain.attribute.entity.Attribute;

public interface AttributeServicePort {
    
    Attribute create(Attribute attribute);

    Attribute findById(Long id);

    Attribute findByName(String name);

    Attribute update(Long id, Attribute updateAttribute);

    void deleteById(Long id);
}
