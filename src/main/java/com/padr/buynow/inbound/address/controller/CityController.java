package com.padr.buynow.inbound.address.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padr.buynow.domain.address.port.CityServicePort;
import com.padr.buynow.inbound.address.model.CityResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/addresses/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityServicePort cityServicePort;

    @GetMapping("/state/id/{stateId}")
    public List<CityResponse> findByStateId(@PathVariable Long stateId) {
        return cityServicePort.findByStateId(stateId).stream().map(CityResponse::of).collect(Collectors.toList());
    }
}
