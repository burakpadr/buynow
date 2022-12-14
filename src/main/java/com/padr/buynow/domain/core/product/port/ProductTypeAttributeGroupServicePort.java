package com.padr.buynow.domain.core.product.port;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;

public interface ProductTypeAttributeGroupServicePort {
    
    ProductTypeAttributeGroup create(ProductTypeAttributeGroup productTypeAttributeGroup);

    public ProductTypeAttributeGroup findById(Long id);

    ProductTypeAttributeGroup update(Long id, ProductTypeAttributeGroup updateProductTypeAttributeGroup);

    void deleteById(Long id);
}
