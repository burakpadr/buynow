package com.padr.buynow.outbound.persistence.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.product.entity.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    
    Optional<ProductType> findByName(String name);

    List<ProductType> findByParentProductTypeId(Long parentProductTypeId);
}
