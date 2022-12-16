package com.padr.buynow.domain.core.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.exception.ProductTypeNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductTypePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeService {

    private final ProductTypePersistencePort productTypePersistencePort;

    public ProductType createProductType(ProductType productType) {
        productType.setIsActive(true);

        return productTypePersistencePort.save(productType);
    }

    public ProductType findById(Long id) {
        return productTypePersistencePort.findById(id).orElseThrow(ProductTypeNotFoundException::new);
    }

    public List<ProductType> findByParentProductTypeId(Long productTypeId) {
        return productTypePersistencePort.findByParentProductTypeId(productTypeId);
    }

    public ProductType updateProductType(Long id, ProductType updateProductType) {
        ProductType productType = findById(id);

        productType.setLabel(updateProductType.getLabel());
        
        return productTypePersistencePort.save(productType);
    }

    public void deleteById(Long id) {
        ProductType productType = findById(id);

        productType.setIsActive(false);

        productTypePersistencePort.save(productType);
    }
}
