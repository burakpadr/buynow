package com.padr.buynow.domain.core.product.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.exception.ProductTypeAttributeGroupNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributeGroupPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeAttributeGroupService {

    private final ProductTypeAttributeGroupPersistencePort productTypeAttributeGroupPersistencePort;

    public ProductTypeAttributeGroup create(
            ProductTypeAttributeGroup productTypeAttributeGroup) {
        productTypeAttributeGroup.setIsActive(true);

        return productTypeAttributeGroupPersistencePort.save(productTypeAttributeGroup);
    }

    public ProductTypeAttributeGroup findById(Long id) {
        return productTypeAttributeGroupPersistencePort.findById(id)
                .orElseThrow(ProductTypeAttributeGroupNotFoundException::new);
    }

    public ProductTypeAttributeGroup update(Long id, ProductTypeAttributeGroup updateProductTypeAttributeGroup) {
        ProductTypeAttributeGroup productTypeAttributeGroup = findById(id);

        productTypeAttributeGroup.setLabel(updateProductTypeAttributeGroup.getLabel());

        return productTypeAttributeGroupPersistencePort.save(productTypeAttributeGroup);
    }

    public void deleteById(Long id) {
        ProductTypeAttributeGroup productTypeAttributeGroup = findById(id);

        productTypeAttributeGroup.setIsActive(false);

        productTypeAttributeGroupPersistencePort.save(productTypeAttributeGroup);
    }
}
