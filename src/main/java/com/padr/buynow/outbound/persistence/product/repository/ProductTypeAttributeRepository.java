package com.padr.buynow.outbound.persistence.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;

@Repository
public interface ProductTypeAttributeRepository extends JpaRepository<ProductTypeAttribute, Long> {
    
}
