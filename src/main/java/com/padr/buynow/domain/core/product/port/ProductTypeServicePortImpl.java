package com.padr.buynow.domain.core.product.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.service.ProductTypeService;

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
    public List<ProductType> findByParentProductTypeId(Long parentProductTypeId) {
        return productTypeService.findByParentProductTypeId(parentProductTypeId);
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
