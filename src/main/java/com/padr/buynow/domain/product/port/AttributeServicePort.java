package com.padr.buynow.domain.product.port;

import java.util.List;

import com.padr.buynow.domain.product.entity.Attribute;

public interface AttributeServicePort {
    
    Attribute create(Attribute attribute);

    Attribute findById(Long id);

    Attribute findByName(String name);

    List<Attribute> findByProductTypeAttrinuteGroupId(Long productTypeAttributeGroupId);

    Attribute update(Long id, Attribute updateAttribute);

    void deleteById(Long id);
}
