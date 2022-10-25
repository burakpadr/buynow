package com.padr.buynow.domain.product.port;

import java.util.List;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeValue;

public interface ProductTypeAttributeValueServicePort {
    
    List<ProductTypeAttributeValue> create(List<ProductTypeAttributeValue> attributeValues);

    ProductTypeAttributeValue findById(Long id);

    List<ProductTypeAttributeValue> findByAttributeId(Long attributeId);

    ProductTypeAttributeValue update(Long id, ProductTypeAttributeValue updateAttributeValue);

    void deleteById(Long id);
}
