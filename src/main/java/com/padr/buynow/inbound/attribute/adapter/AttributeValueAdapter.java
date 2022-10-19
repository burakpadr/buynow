package com.padr.buynow.inbound.attribute.adapter;

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

import com.padr.buynow.domain.attribute.entity.Attribute;
import com.padr.buynow.domain.attribute.entity.AttributeValue;
import com.padr.buynow.domain.attribute.port.AttributeServicePort;
import com.padr.buynow.domain.attribute.port.AttributeValueServicePort;
import com.padr.buynow.inbound.attribute.model.request.AttributeValueRequest;
import com.padr.buynow.inbound.attribute.model.response.AttributeValueResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attribute-values")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class AttributeValueAdapter {

    private final AttributeValueServicePort attributeValueServicePort;
    private final AttributeServicePort attributeServicePort;

    @PostMapping
    public AttributeValueResponse create(@Valid @RequestBody AttributeValueRequest attributeValueRequest) {
        Attribute attribute = attributeServicePort.findById(attributeValueRequest.getAttributeId());

        AttributeValue attributeValue = attributeValueRequest.to();
        attributeValue.setAttribute(attribute);

        return AttributeValueResponse.of(attributeValueServicePort.create(attributeValue));
    }

    @GetMapping("/by/id/{id}")
    public AttributeValueResponse findById(@PathVariable Long id) {
        return AttributeValueResponse.of(attributeValueServicePort.findById(id));
    }

    @GetMapping("/by/attribute/{id}")
    public List<AttributeValueResponse> findByAttributeId(@PathVariable Long id) {
        return attributeValueServicePort.findByAttributeId(id).stream().map(AttributeValueResponse::of)
                .collect(Collectors.toList());
    }

    @PutMapping("/by/id/{id}") 
    public AttributeValueResponse update(@PathVariable Long id, @Valid @RequestBody AttributeValueRequest updateAttributeValueRequest) {
        Attribute attribute = attributeServicePort.findById(updateAttributeValueRequest.getAttributeId());

        AttributeValue updateAttributeValue = updateAttributeValueRequest.to();
        updateAttributeValue.setAttribute(attribute);

        return AttributeValueResponse.of(attributeValueServicePort.update(id, updateAttributeValue));
    }

    @DeleteMapping("/by/id/{id}")
    public void deleteById(@PathVariable Long id) {
        attributeValueServicePort.deleteById(id);
    }
}
