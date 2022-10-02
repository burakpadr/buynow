package com.padr.buynow.inbound.address.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padr.buynow.domain.address.port.CountryServicePort;
import com.padr.buynow.inbound.address.model.CountryResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/addresses/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryServicePort countryServicePort;

    @GetMapping
    public List<CountryResponse> findAllCountries() {
        return countryServicePort.findAllCountries().stream().map(CountryResponse::of).collect(Collectors.toList());
    }
}
