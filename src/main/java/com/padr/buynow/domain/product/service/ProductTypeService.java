package com.padr.buynow.domain.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.product.entity.ProductType;
import com.padr.buynow.domain.product.exception.ProductTypeAlreadyExistWithNameException;
import com.padr.buynow.domain.product.exception.ProductTypeNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductTypePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeService {

    private final ProductTypePersistencePort productTypePersistencePort;

    public ProductType createProductType(ProductType productType) {
        productTypePersistencePort.findByName(productType.getName()).ifPresent(pt -> {
            throw new ProductTypeAlreadyExistWithNameException();
        });

        productType.setIsActive(true);

        return productTypePersistencePort.save(productType);
    }

    public ProductType findById(Long id) {
        return productTypePersistencePort.findById(id).orElseThrow(ProductTypeNotFoundException::new);
    }

    public ProductType findByName(String name) {
        return productTypePersistencePort.findByName(name).orElseThrow(ProductTypeNotFoundException::new);
    }

    public List<ProductType> findByParentProductTypeId(Long productTypeId) {
        return productTypePersistencePort.findByParentProductTypeId(productTypeId);
    }

    public ProductType updateProductType(Long id, ProductType updateProductType) {
        ProductType productType = findById(id);

        productTypePersistencePort.findByName(updateProductType.getName()).ifPresent(pt -> {
            if (pt.getId() != productType.getId())
                throw new ProductTypeAlreadyExistWithNameException(); 
        });

        productType.setName(updateProductType.getName());
        productType.setDescription(updateProductType.getDescription());
        
        return productTypePersistencePort.save(productType);
    }

    public void deleteById(Long id) {
        ProductType productType = findById(id);

        productType.setIsActive(false);

        productTypePersistencePort.save(productType);
    }
}
