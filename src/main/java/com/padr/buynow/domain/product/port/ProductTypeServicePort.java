package com.padr.buynow.domain.product.port;

import com.padr.buynow.domain.product.entity.ProductType;

public interface ProductTypeServicePort {
    
    ProductType createProductType(ProductType productType);

    ProductType findById(Long id);

    ProductType findByName(String name);

    ProductType updateProductType(Long id, ProductType updateProductType);

    public void deleteById(Long id);
}