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

import com.padr.buynow.domain.frontend.entity.InputFieldType;
import com.padr.buynow.domain.frontend.service.InputFieldTypeService;
import com.padr.buynow.domain.product.entity.ProductTypeAttribute;
import com.padr.buynow.domain.product.port.ProductTypeAttributeServicePort;
import com.padr.buynow.inbound.product.model.request.ProductTypeAttributeRequest;
import com.padr.buynow.inbound.product.model.response.ProductTypeAttributeResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attributes")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class ProductTypeAttributeAdapter {

    private final ProductTypeAttributeServicePort productTypeAttributeServicePort;
    private final InputFieldTypeService inputFieldTypeService;

    @PostMapping
    public ProductTypeAttributeResponse create(@Valid @RequestBody ProductTypeAttributeRequest attributeRequest) {
        InputFieldType inputFieldType = inputFieldTypeService.findById(attributeRequest.getInputFieldTypeId());

        ProductTypeAttribute attribute = attributeRequest.to();
        attribute.setInputFieldType(inputFieldType);

        return ProductTypeAttributeResponse.of(productTypeAttributeServicePort.create(attribute));
    }

    @GetMapping("/by/id/{id}")
    public ProductTypeAttributeResponse findById(@PathVariable Long id) {
        return ProductTypeAttributeResponse.of(productTypeAttributeServicePort.findById(id));
    }

    @GetMapping("/by/name/{name}")
    public ProductTypeAttributeResponse findByName(@PathVariable String name) {
        return ProductTypeAttributeResponse.of(productTypeAttributeServicePort.findByName(name));
    }

    @GetMapping("/by/product-type-attribute-group/{id}")
    public List<ProductTypeAttributeResponse> findByProductTypeAttributeGroupId(@PathVariable Long id) {
        return productTypeAttributeServicePort.findByProductTypeAttrinuteGroupId(id)
                .stream()
                .map(ProductTypeAttributeResponse::of)
                .collect(Collectors.toList());
    }

    @PutMapping("/by/id/{id}")
    public ProductTypeAttributeResponse update(@PathVariable Long id,
            @Valid @RequestBody ProductTypeAttributeRequest updateAttributeRequest) {
        InputFieldType inputFieldType = inputFieldTypeService.findById(updateAttributeRequest.getInputFieldTypeId());

        ProductTypeAttribute attribute = updateAttributeRequest.to();
        attribute.setInputFieldType(inputFieldType);

        return ProductTypeAttributeResponse.of(productTypeAttributeServicePort.update(id, attribute));
    }

    @DeleteMapping("/by/id/{id}")
    public void deleteById(@PathVariable Long id) {
        productTypeAttributeServicePort.deleteById(id);
    }
}
