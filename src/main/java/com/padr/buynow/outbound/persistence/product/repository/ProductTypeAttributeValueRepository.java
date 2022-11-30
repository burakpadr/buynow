package com.padr.buynow.outbound.persistence.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;

@Repository
public interface ProductTypeAttributeValueRepository extends JpaRepository<ProductTypeAttributeValue, Long> {
    
    List<ProductTypeAttributeValue> findByProductTypeAttributeIdAndIsActive(Long attributeId, Boolean isActive);
}
