package com.padr.buynow.domain.core.product.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductTypeAttributeGroupServicePortImpl implements ProductTypeAttributeGroupServicePort {
    
    private final ProductTypeAttributeGroupService productTypeAttributeGroupService;

    @Override
    public ProductTypeAttributeGroup create(ProductTypeAttributeGroup productTypeAttributeGroup) {
        return productTypeAttributeGroupService.create(productTypeAttributeGroup);
    }

    @Override
    public ProductTypeAttributeGroup findById(Long id) {
        return productTypeAttributeGroupService.findById(id);
    }

    @Override
    public ProductTypeAttributeGroup findByName(String name) {
        return productTypeAttributeGroupService.findByName(name);
    }

    @Override
    public List<ProductTypeAttributeGroup> findByProductTypeId(Long productTypeId) {
        return productTypeAttributeGroupService.findByProductTypeId(productTypeId);
    }

    @Override
    public ProductTypeAttributeGroup update(Long id, ProductTypeAttributeGroup updateProductTypeAttributeGroup) {
        return productTypeAttributeGroupService.update(id, updateProductTypeAttributeGroup);
    }

    @Override
    public void deleteById(Long id) {
        productTypeAttributeGroupService.deleteById(id);
    }
}
