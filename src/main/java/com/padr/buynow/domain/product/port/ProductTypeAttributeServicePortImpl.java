package com.padr.buynow.domain.product.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.product.service.ProductTypeAttributeService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductTypeAttributeServicePortImpl implements ProductTypeAttributeServicePort {

    private final ProductTypeAttributeService attributeService;

    @Override
    public ProductTypeAttribute create(ProductTypeAttribute attribute) {
        return attributeService.create(attribute);
    }

    @Override
    public ProductTypeAttribute findById(Long id) {
        return attributeService.findById(id);
    }

    @Override
    public ProductTypeAttribute findByName(String name) {
        return attributeService.findByName(name);
    }

    @Override
    public List<ProductTypeAttribute> findByProductTypeAttributeGroupId(Long productTypeAttributeGroupId) {
        return attributeService.findByProductTypeAttributeGroupId(productTypeAttributeGroupId);
    }

    @Override
    public ProductTypeAttribute update(Long id, ProductTypeAttribute updateAttribute) {
        return attributeService.update(id, updateAttribute);
    }

    @Override
    public void deleteById(Long id) {
        attributeService.deleteById(id);
    }
}
