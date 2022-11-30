package com.padr.buynow.inbound.frontend.adapter;

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

import com.padr.buynow.domain.core.frontend.port.InputFieldTypeServicePort;
import com.padr.buynow.inbound.frontend.model.request.InputFieldTypeRequest;
import com.padr.buynow.inbound.frontend.model.response.InputFieldTypeResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/input-field-types")
@ResponseStatus(HttpStatus.OK)
@RequiredArgsConstructor
public class InputFieldTypeAdapter {
    
    private final InputFieldTypeServicePort inputFieldTypeServicePort;

    @PostMapping
    public InputFieldTypeResponse create(@Valid @RequestBody InputFieldTypeRequest inputFieldTypeRequest) {
        return InputFieldTypeResponse.of(inputFieldTypeServicePort.create(inputFieldTypeRequest.to()));
    }

    @GetMapping("/by/id/{id}")
    public InputFieldTypeResponse findById(@PathVariable Long id) {
        return InputFieldTypeResponse.of(inputFieldTypeServicePort.findById(id));
    }

    @GetMapping("/by/name/{name}")
    public InputFieldTypeResponse findByName(@PathVariable String name) {
        return InputFieldTypeResponse.of(inputFieldTypeServicePort.findByName(name));
    }

    @PutMapping("/by/id/{id}")
    public InputFieldTypeResponse update(@PathVariable Long id, @Valid @RequestBody InputFieldTypeRequest updateInputFieldTypeRequest) {
        return InputFieldTypeResponse.of(inputFieldTypeServicePort.update(id, updateInputFieldTypeRequest.to()));
    }

    @DeleteMapping("/by/id/{id}")
    public void deleteById(@PathVariable Long id) {
        inputFieldTypeServicePort.deleteById(id);
    }
}
