package com.padr.buynow.domain.product.port;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.product.entity.ProductType;
import com.padr.buynow.domain.product.service.ProductTypeService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductTypeServicePortImpl implements ProductTypeServicePort {

    private final ProductTypeService productTypeService;

    @Override
    public ProductType createProductType(ProductType productType) {
        return productTypeService.createProductType(productType);
    }

    @Override
    public ProductType findById(Long id) {
        return productTypeService.findById(id);
    }

    @Override
    public ProductType findByName(String name) {
        return productTypeService.findByName(name);
    }

    @Override
    public ProductType updateProductType(Long id, ProductType updateProductType) {
        return productTypeService.updateProductType(id, updateProductType);
    }

    @Override
    public void deleteById(Long id) {
        productTypeService.deleteById(id);
    }

}
