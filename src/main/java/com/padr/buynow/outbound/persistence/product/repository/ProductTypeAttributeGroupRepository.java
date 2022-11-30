package com.padr.buynow.outbound.persistence.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;

@Repository
public interface ProductTypeAttributeGroupRepository extends JpaRepository<ProductTypeAttributeGroup, Long> {

    Optional<ProductTypeAttributeGroup> findByName(String name);

    List<ProductTypeAttributeGroup> findByProductType(Long productTypeId);
}
