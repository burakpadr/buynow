package com.padr.buynow.domain.core.product.port;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;

public interface ProductTypeAttributeServicePort {
    
    ProductTypeAttribute create(ProductTypeAttribute attribute);

    ProductTypeAttribute findById(Long id);

    ProductTypeAttribute update(Long id, ProductTypeAttribute updateAttribute);

    void deleteById(Long id);
}
