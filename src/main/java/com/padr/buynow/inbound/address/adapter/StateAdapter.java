package com.padr.buynow.inbound.address.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padr.buynow.domain.address.port.StateServicePort;
import com.padr.buynow.inbound.address.model.response.StateResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/addresses/states")
@RequiredArgsConstructor
public class StateAdapter {

    private final StateServicePort stateServicePort;

    @GetMapping("/country/id/{countryId}")
    public List<StateResponse> findByCountryId(@PathVariable Long countryId) {
        return stateServicePort.findByCountryId(countryId).stream().map(StateResponse::of).collect(Collectors.toList());
    }
}
