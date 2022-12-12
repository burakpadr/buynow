package com.padr.buynow.domain.core.product.port;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;

public interface ProductTypeAttributeValueServicePort {
    
    List<ProductTypeAttributeValue> create(List<ProductTypeAttributeValue> attributeValues);

    ProductTypeAttributeValue findById(Long id);

    ProductTypeAttributeValue update(Long id, ProductTypeAttributeValue updateAttributeValue);

    void deleteById(Long id);
}
