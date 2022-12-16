package com.padr.buynow.domain.core.product.port;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductType;

public interface ProductTypeServicePort {
    
    ProductType createProductType(ProductType productType);

    ProductType findById(Long id);

    List<ProductType> findByParentProductTypeId(Long parentProductTypeId);

    ProductType updateProductType(Long id, ProductType updateProductType);

    public void deleteById(Long id);
}
