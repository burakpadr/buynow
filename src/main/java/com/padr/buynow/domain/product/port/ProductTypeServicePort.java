package com.padr.buynow.domain.product.port;

import java.util.List;

import com.padr.buynow.domain.product.entity.ProductType;

public interface ProductTypeServicePort {
    
    ProductType createProductType(ProductType productType);

    ProductType findById(Long id);

    ProductType findByName(String name);

    List<ProductType> findByParentProductTypeId(Long parentProductTypeId);

    ProductType updateProductType(Long id, ProductType updateProductType);

    public void deleteById(Long id);
}
