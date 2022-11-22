package com.padr.buynow.inbound.product.adapter;

import java.util.ArrayList;
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

import com.padr.buynow.domain.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.product.port.ProductTypeAttributeServicePort;
import com.padr.buynow.domain.product.port.ProductTypeAttributeValueServicePort;
import com.padr.buynow.inbound.product.model.request.ProductTypeAttributeValueRequest;
import com.padr.buynow.inbound.product.model.response.ProductTypeAttributeValueResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attribute-values")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class ProductTypeAttributeValueAdapter {

    private final ProductTypeAttributeValueServicePort productTypeAttributeValueServicePort;
    private final ProductTypeAttributeServicePort productTypeAttributeServicePort;

    @PostMapping
    public List<ProductTypeAttributeValueResponse> create(
            @Valid @RequestBody List<ProductTypeAttributeValueRequest> attributeValuesRequest) {
        List<ProductTypeAttributeValue> attributeValues = new ArrayList<>();

        attributeValuesRequest.parallelStream().forEach(attributeValueRequest -> {
            ProductTypeAttribute attribute = productTypeAttributeServicePort
                    .findById(attributeValueRequest.getAttributeId());

            ProductTypeAttributeValue attributeValue = attributeValueRequest.to();
            attributeValue.setProductTypeAttribute(attribute);
        });

        return productTypeAttributeValueServicePort.create(attributeValues).stream()
                .map(ProductTypeAttributeValueResponse::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/by/id/{id}")
    public ProductTypeAttributeValueResponse findById(@PathVariable Long id) {
        return ProductTypeAttributeValueResponse.of(productTypeAttributeValueServicePort.findById(id));
    }

    @GetMapping("/by/attribute/{id}")
    public List<ProductTypeAttributeValueResponse> findByAttributeId(@PathVariable Long id) {
        return productTypeAttributeValueServicePort.findByAttributeId(id).stream()
                .map(ProductTypeAttributeValueResponse::of)
                .collect(Collectors.toList());
    }

    @PutMapping("/by/id/{id}")
    public ProductTypeAttributeValueResponse update(@PathVariable Long id,
            @Valid @RequestBody ProductTypeAttributeValueRequest updateAttributeValueRequest) {
        ProductTypeAttribute attribute = productTypeAttributeServicePort
                .findById(updateAttributeValueRequest.getAttributeId());

        ProductTypeAttributeValue updateAttributeValue = updateAttributeValueRequest.to();
        updateAttributeValue.setProductTypeAttribute(attribute);

        return ProductTypeAttributeValueResponse
                .of(productTypeAttributeValueServicePort.update(id, updateAttributeValue));
    }

    @DeleteMapping("/by/id/{id}")
    public void deleteById(@PathVariable Long id) {
        productTypeAttributeValueServicePort.deleteById(id);
    }
}
