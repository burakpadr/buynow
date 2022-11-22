package com.padr.buynow.domain.product.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.product.entity.ProductAttribute;
import com.padr.buynow.domain.product.exception.ProductAttributeNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductAttributePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductAttributeService {

    private final ProductAttributePersistencePort productAttributePersistencePort;

    public List<ProductAttribute> createProductAttributes(List<ProductAttribute> productAttributes) {
        productAttributes.parallelStream().forEach(productAttribute -> {
            if (Objects.nonNull(productAttribute.getProductTypeAttributeValue()))
                productAttribute.setValue(productAttribute.getProductTypeAttributeValue().getValue());

            productAttribute.setIsActive(true);
        });

        return productAttributePersistencePort.saveAll(productAttributes);
    }

    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
        if (Objects.nonNull(productAttribute.getProductTypeAttributeValue()))
            productAttribute.setValue(productAttribute.getProductTypeAttributeValue().getValue());

        productAttribute.setIsActive(true);

        return productAttributePersistencePort.save(productAttribute);
    }

    public ProductAttribute findById(Long id) {
        return productAttributePersistencePort.findById(id).orElseThrow(ProductAttributeNotFoundException::new);
    }

    public List<ProductAttribute> findByProductId(Long productId) {
        return productAttributePersistencePort.findByProductId(productId);
    }

    public List<ProductAttribute> update(Long productId, List<ProductAttribute> updateProductAttributes) {
        List<ProductAttribute> productAttributes = findByProductId(productId);

        updateProductAttributes.parallelStream().forEach(updateProductAttribute -> {
            if (Objects.isNull(updateProductAttribute.getId()))
                productAttributes.add(createProductAttribute(updateProductAttribute));
            else {
                ProductAttribute productAttribute = productAttributes.parallelStream()
                        .filter(p -> p.getId() == updateProductAttribute.getId()).findAny().orElse(null);

                if (Objects.nonNull(productAttribute)) {
                    if (Objects.nonNull(updateProductAttribute.getProductTypeAttributeValue()))
                        productAttribute.setValue(updateProductAttribute.getProductTypeAttributeValue().getValue());
                    else {
                        productAttribute.setValue(updateProductAttribute.getValue());
                        productAttribute.setProductTypeAttributeValue(null);
                    }
                }
            }
        });

        return productAttributePersistencePort.saveAll(productAttributes);
    }

    public void deleteAllByProductId(Long productId) {
        List<ProductAttribute> productAttributes = findByProductId(productId);

        productAttributes.parallelStream().forEach(productAttribute -> {
            productAttribute.setIsActive(false);
        });

        productAttributePersistencePort.saveAll(productAttributes);
    }

    public void deleteById(Long id) {
        ProductAttribute productAttribute = findById(id);

        productAttribute.setIsActive(false);

        productAttributePersistencePort.save(productAttribute);
    }
}
