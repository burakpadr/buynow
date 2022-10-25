package com.padr.buynow.domain.product.port;

import java.util.List;

import com.padr.buynow.domain.product.entity.ProductTypeAttribute;

public interface ProductTypeAttributeServicePort {
    
    ProductTypeAttribute create(ProductTypeAttribute attribute);

    ProductTypeAttribute findById(Long id);

    ProductTypeAttribute findByName(String name);

    List<ProductTypeAttribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId);

    ProductTypeAttribute update(Long id, ProductTypeAttribute updateAttribute);

    void deleteById(Long id);
}
