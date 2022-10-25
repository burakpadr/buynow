package com.padr.buynow.outbound.persistence.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.product.entity.ProductTypeAttribute;

@Repository
public interface ProductTypeAttributeRepository extends JpaRepository<ProductTypeAttribute, Long> {
    
    Optional<ProductTypeAttribute> findByName(String name);

    List<ProductTypeAttribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId);
}
