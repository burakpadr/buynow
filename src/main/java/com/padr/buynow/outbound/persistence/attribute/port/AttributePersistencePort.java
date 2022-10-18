package com.padr.buynow.outbound.persistence.attribute.port;

import java.util.Optional;

import com.padr.buynow.domain.attribute.entity.Attribute;

public interface AttributePersistencePort {
    
    public Optional<Attribute> findById(Long id);

    public Optional<Attribute> findByName(String name);

    public Attribute save(Attribute attribute);
}
