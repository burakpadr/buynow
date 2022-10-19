package com.padr.buynow.inbound.attribute.adapter;

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
import com.padr.buynow.domain.attribute.port.AttributeServicePort;
import com.padr.buynow.domain.frontend.entity.InputFieldType;
import com.padr.buynow.domain.frontend.service.InputFieldTypeService;
import com.padr.buynow.inbound.attribute.model.request.AttributeRequest;
import com.padr.buynow.inbound.attribute.model.response.AttributeResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attributes")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class AttributeAdapter {
    
    private final AttributeServicePort attributeServicePort;
    private final InputFieldTypeService inputFieldTypeService;

    @PostMapping
    public AttributeResponse create(@Valid @RequestBody AttributeRequest attributeRequest) {
        InputFieldType inputFieldType = inputFieldTypeService.findById(attributeRequest.getInputFieldTypeId());

        Attribute attribute = attributeRequest.to();
        attribute.setInputFieldType(inputFieldType);

        return AttributeResponse.of(attributeServicePort.create(attribute));
    }

    @GetMapping("/by/id/{id}")
    public AttributeResponse findById(@PathVariable Long id){
        return AttributeResponse.of(attributeServicePort.findById(id));
    }

    @GetMapping("/by/name/{name}")
    public AttributeResponse findByName(@PathVariable String name){
        return AttributeResponse.of(attributeServicePort.findByName(name));
    }

    @PutMapping("/id/{id}")
    public AttributeResponse update(@PathVariable Long id, @Valid @RequestBody AttributeRequest updateAttributeRequest) {
        InputFieldType inputFieldType = inputFieldTypeService.findById(updateAttributeRequest.getInputFieldTypeId());

        Attribute attribute = updateAttributeRequest.to();
        attribute.setInputFieldType(inputFieldType);

        return AttributeResponse.of(attributeServicePort.update(id, attribute));
    }

    @DeleteMapping("/by/id/{id}")
    public void deleteById(@PathVariable Long id) {
        attributeServicePort.deleteById(id);
    }
}
