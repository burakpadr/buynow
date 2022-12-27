package com.padr.buynow.domain.usecase.product.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.domain.core.product.entity.ProductAttribute;
import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.core.product.service.ProductAttributeService;
import com.padr.buynow.domain.core.product.service.ProductService;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeValueService;
import com.padr.buynow.domain.core.product.service.ProductTypeService;
import com.padr.buynow.domain.core.user.entity.User;
import com.padr.buynow.domain.core.user.service.UserService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.CreateProductModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateProduct implements BaseUseCase<Product, CreateProductModel> {

    private final ProductService productService;
    private final ProductTypeService productTypeService;
    private final ProductAttributeService productAttributeService;
    private final ProductTypeAttributeService productTypeAttributeService;
    private final ProductTypeAttributeValueService productTypeAttributeValueService;
    private final UserService userService;

    @Override
    public Product perform(CreateProductModel model) {
        ProductType productType = productTypeService.findById(model.getProductTypeId());
        User user = userService.findUserById(model.getOwnerUserId());

        Product product = model.to();
        product.setProductType(productType);
        product.setOwnerUser(user);

        Product savedProduct = productService.create(product);

        List<ProductAttribute> productAttributes = model.getAttributeModels().parallelStream().map(attributeModel -> {
            ProductTypeAttribute productTypeAttribute = productTypeAttributeService
                    .findById(attributeModel.getProductTypeAttributeId());

            ProductTypeAttributeValue productTypeAttributeValue = Objects
                    .nonNull(attributeModel.getProductTypeAttributeValueId())
                            ? productTypeAttributeValueService.findById(attributeModel.getProductTypeAttributeValueId())
                            : null;

            ProductAttribute productAttribute = attributeModel.to();
            productAttribute.setProduct(savedProduct);
            productAttribute.setProductTypeAttribute(productTypeAttribute);
            productAttribute.setProductTypeAttributeValue(productTypeAttributeValue);

            return productAttribute;
        }).collect(Collectors.toList());

        productAttributeService.createProductAttributes(productAttributes);

        savedProduct.setProductAttributes(productAttributes);

        return savedProduct;
    }
}
