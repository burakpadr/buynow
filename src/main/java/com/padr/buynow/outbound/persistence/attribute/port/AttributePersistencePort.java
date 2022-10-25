package com.padr.buynow.outbound.persistence.attribute.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.product.entity.Attribute;

public interface AttributePersistencePort {
    
    public Optional<Attribute> findById(Long id);

    public Optional<Attribute> findByName(String name);

    List<Attribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId);

    public Attribute save(Attribute attribute);
}
