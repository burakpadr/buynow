package com.padr.buynow.outbound.persistence.attribute.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.product.entity.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    
    Optional<Attribute> findByName(String name);

    List<Attribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId);
}
