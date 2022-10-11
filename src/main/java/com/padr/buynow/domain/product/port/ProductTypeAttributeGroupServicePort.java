package com.padr.buynow.domain.product.port;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeGroup;

public interface ProductTypeAttributeGroupServicePort {
    
    ProductTypeAttributeGroup create(ProductTypeAttributeGroup productTypeAttributeGroup);

    public ProductTypeAttributeGroup findById(Long id);

    public ProductTypeAttributeGroup findByName(String name);

    ProductTypeAttributeGroup update(Long id, ProductTypeAttributeGroup updateProductTypeAttributeGroup);

    void deleteById(Long id);
}
