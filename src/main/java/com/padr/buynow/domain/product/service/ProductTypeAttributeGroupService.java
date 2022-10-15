package com.padr.buynow.domain.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.product.exception.ProductTypeAttributeGroupAlreadyExistWithNameException;
import com.padr.buynow.domain.product.exception.ProductTypeAttributeGroupNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributeGroupPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeAttributeGroupService {

    private final ProductTypeAttributeGroupPersistencePort productTypeAttributeGroupPersistencePort;

    public ProductTypeAttributeGroup create(
            ProductTypeAttributeGroup productTypeAttributeGroup) {
        productTypeAttributeGroupPersistencePort.findByName(productTypeAttributeGroup.getName()).ifPresent(ptag -> {
            throw new ProductTypeAttributeGroupAlreadyExistWithNameException();
        });

        productTypeAttributeGroup.setIsActive(true);

        return productTypeAttributeGroupPersistencePort.save(productTypeAttributeGroup);
    }

    public ProductTypeAttributeGroup findById(Long id) {
        return productTypeAttributeGroupPersistencePort.findById(id)
                .orElseThrow(ProductTypeAttributeGroupNotFoundException::new);
    }

    public ProductTypeAttributeGroup findByName(String name) {
        return productTypeAttributeGroupPersistencePort.findByName(name)
                .orElseThrow(ProductTypeAttributeGroupNotFoundException::new);
    }

    public List<ProductTypeAttributeGroup> findByProductTypeId(Long productTypeId) {
        return productTypeAttributeGroupPersistencePort.findByProductType(productTypeId);
    }

    public ProductTypeAttributeGroup update(Long id, ProductTypeAttributeGroup updateProductTypeAttributeGroup) {
        ProductTypeAttributeGroup productTypeAttributeGroup = findById(id);

        productTypeAttributeGroupPersistencePort.findByName(updateProductTypeAttributeGroup.getName())
                .ifPresent(ptag -> {
                    if (ptag.getId() != productTypeAttributeGroup.getId())
                        throw new ProductTypeAttributeGroupAlreadyExistWithNameException();
                });

        productTypeAttributeGroup.setName(updateProductTypeAttributeGroup.getName());
        productTypeAttributeGroup.setLabel(updateProductTypeAttributeGroup.getLabel());

        return productTypeAttributeGroupPersistencePort.save(productTypeAttributeGroup);
    }

    public void deleteById(Long id) {
        ProductTypeAttributeGroup productTypeAttributeGroup = findById(id);

        productTypeAttributeGroup.setIsActive(false);

        productTypeAttributeGroupPersistencePort.save(productTypeAttributeGroup);
    }
}
