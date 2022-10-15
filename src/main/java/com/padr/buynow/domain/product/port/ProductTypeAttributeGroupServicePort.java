package com.padr.buynow.domain.product.port;

import java.util.List;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeGroup;

public interface ProductTypeAttributeGroupServicePort {
    
    ProductTypeAttributeGroup create(ProductTypeAttributeGroup productTypeAttributeGroup);

    public ProductTypeAttributeGroup findById(Long id);

    public ProductTypeAttributeGroup findByName(String name);

    List<ProductTypeAttributeGroup> findByProductTypeId(Long productTypeId);

    ProductTypeAttributeGroup update(Long id, ProductTypeAttributeGroup updateProductTypeAttributeGroup);

    void deleteById(Long id);
}
