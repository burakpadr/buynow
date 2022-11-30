package com.padr.buynow.inbound.product.adapter;

import java.util.List;
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

import com.padr.buynow.domain.core.product.entity.ProductType;
import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.port.ProductTypeAttributeGroupServicePort;
import com.padr.buynow.domain.core.product.port.ProductTypeServicePort;
import com.padr.buynow.inbound.product.model.request.ProductTypeAttributeGroupRequest;
import com.padr.buynow.inbound.product.model.response.ProductTypeAttributeGroupResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product-type-attr-groups")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class ProductTypeAttributeGroupAdapter {

    private final ProductTypeAttributeGroupServicePort productTypeAttributeGroupServicePort;
    private final ProductTypeServicePort productTypeServicePort;

    @PostMapping
    public ProductTypeAttributeGroupResponse create(
            @Valid @RequestBody ProductTypeAttributeGroupRequest productTypeAttributeGroupRequest) {
        ProductType productType = productTypeServicePort.findById(productTypeAttributeGroupRequest.getProductTypeId());

        ProductTypeAttributeGroup productTypeAttributeGroup = productTypeAttributeGroupRequest.to();
        productTypeAttributeGroup.setProductType(productType);

        return ProductTypeAttributeGroupResponse
                .of(productTypeAttributeGroupServicePort.create(productTypeAttributeGroup));
    }

    @GetMapping("/by/id/{id}")
    public ProductTypeAttributeGroupResponse findById(@PathVariable Long id) {
        return ProductTypeAttributeGroupResponse.of(productTypeAttributeGroupServicePort.findById(id));
    }

    @GetMapping("/by/name/{name}")
    public ProductTypeAttributeGroupResponse findByName(@PathVariable String name) {
        return ProductTypeAttributeGroupResponse.of(productTypeAttributeGroupServicePort.findByName(name));
    }

    @GetMapping("/by/product-type/{productTypeId}")
    public List<ProductTypeAttributeGroupResponse> findByProductTypeId(@PathVariable Long productTypeId) {
        return productTypeAttributeGroupServicePort.findByProductTypeId(productTypeId).stream()
                .map(ProductTypeAttributeGroupResponse::of).collect(Collectors.toList());
    }

    @PutMapping("/by/id/{id}")
    public ProductTypeAttributeGroupResponse update(@PathVariable Long id, @Valid @RequestBody ProductTypeAttributeGroupRequest request) {
        ProductType productType = productTypeServicePort.findById(request.getProductTypeId());

        ProductTypeAttributeGroup updateProductTypeAttributeGroup = request.to();
        updateProductTypeAttributeGroup.setProductType(productType);

        return ProductTypeAttributeGroupResponse
                .of(productTypeAttributeGroupServicePort.update(id, updateProductTypeAttributeGroup));
    }

    @DeleteMapping("/by/id/{id}")
    public void deleteById(@PathVariable Long id) {
        productTypeAttributeGroupServicePort.deleteById(id);
    }
}
