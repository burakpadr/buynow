package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeValue;

public interface ProductTypeAttributeValuePersistencePort {
    
    Optional<ProductTypeAttributeValue> findById(Long id);

    List<ProductTypeAttributeValue> findByProductTypeAttributeIdAndIsActive(Long attributeId, Boolean isActive);
    
    ProductTypeAttributeValue save(ProductTypeAttributeValue attributeValue);

    List<ProductTypeAttributeValue> saveAll(List<ProductTypeAttributeValue> attributeValues);
}
