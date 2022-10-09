package com.padr.buynow.inbound.product.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.padr.buynow.domain.product.entity.ProductType;
import com.padr.buynow.domain.product.port.ProductTypeServicePort;
import com.padr.buynow.inbound.product.model.request.ProductTypeRequest;
import com.padr.buynow.inbound.product.model.response.ProductTypeResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product-type")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class ProductTypeController {

    private final ProductTypeServicePort productTypeServicePort;

    @PostMapping
    public ProductTypeResponse createProductType(@Valid @RequestBody ProductTypeRequest productTypeRequest) {
        if (Objects.isNull(productTypeRequest.getParentProductTypeId()))
            return ProductTypeResponse.of(productTypeServicePort.createProductType(productTypeRequest.to()));

        ProductType parentProductType = productTypeServicePort.findById(productTypeRequest.getParentProductTypeId());

        ProductType productType = productTypeRequest.to();
        productType.setParentProductType(parentProductType);

        return ProductTypeResponse.of(productTypeServicePort.createProductType(productType));
    }

    @GetMapping("/{productTypeId}")
    public ProductTypeResponse findById(@PathVariable Long productTypeId) {
        return ProductTypeResponse.of(productTypeServicePort.findById(productTypeId));
    }

    @GetMapping("/name/{name}")
    public ProductTypeResponse findByName(@PathVariable String name) {
        return ProductTypeResponse.of(productTypeServicePort.findByName(name));
    }

    @GetMapping("/parent-product-type-id/{parentProductTypeId}")
    public List<ProductTypeResponse> findByParentProductTypeId(@PathVariable Long parentProductTypeId) {
        return productTypeServicePort.findByParentProductTypeId(parentProductTypeId).stream()
                .map(ProductTypeResponse::of).collect(Collectors.toList());
    }

    @PutMapping("/{productTypeId}")
    public ProductTypeResponse updateProductType(@PathVariable Long productTypeId, @Valid @RequestBody ProductTypeRequest updateProductType) {
        return ProductTypeResponse.of(productTypeServicePort.updateProductType(productTypeId, updateProductType.to()));
    }

    @DeleteMapping("/{productTypeId}")
    public void deleteProductTypeById(@PathVariable Long productTypeId) {
        productTypeServicePort.deleteById(productTypeId);
    }
}
