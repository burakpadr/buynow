package com.padr.buynow.domain.usecase.product.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.padr.buynow.domain.core.cart.entity.CartItem;
import com.padr.buynow.domain.core.cart.service.CartItemService;
import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.domain.core.product.entity.ProductAttribute;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.core.product.service.ProductAttributeService;
import com.padr.buynow.domain.core.product.service.ProductService;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeValueService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;
import com.padr.buynow.domain.usecase.product.model.UpdateProductModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateProduct implements BaseUseCase<Product, UpdateProductModel> {

    private final ProductService productService;
    private final ProductAttributeService productAttributeService;
    private final ProductTypeAttributeValueService productTypeAttributeValueService;
    private final CartItemService cartItemService;

    @Override
    public Product perform(UpdateProductModel model) {
        Product updatedProduct = productService.update(model.getId(), model.to());

        notifyObservers(updatedProduct);

        List<ProductAttribute> productAttributes = model.getAttributeModels().parallelStream().map(attributeModel -> {
            ProductAttribute productAttribute = attributeModel.to();

            ProductTypeAttributeValue productTypeAttributeValue = Objects
                    .nonNull(attributeModel.getProductTypeAttributeValueId())
                    ? productTypeAttributeValueService.findById(attributeModel.getProductTypeAttributeValueId())
                    : null;

            productAttribute.setProductTypeAttributeValue(productTypeAttributeValue);

            return productAttribute;
        }).collect(Collectors.toList());

        updatedProduct.setProductAttributes(productAttributeService.update(updatedProduct.getId(), productAttributes));

        return updatedProduct;
    }

    private void notifyObservers(Product product) {
        List<CartItem> cartItems = cartItemService.findByProductId(product.getId());

        cartItems.stream().parallel().forEach(cartItem -> {
            cartItemService.update(cartItem.getId(), product);
        });
    }
}
