package com.padr.buynow.outbound.persistence.attribute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.product.entity.AttributeValue;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
    
    List<AttributeValue> findByAttributeIdAndIsActive(Long attributeId, Boolean isActive);
}
