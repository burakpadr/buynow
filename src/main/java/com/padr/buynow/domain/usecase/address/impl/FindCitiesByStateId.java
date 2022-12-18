package com.padr.buynow.domain.usecase.address.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.City;
import com.padr.buynow.domain.core.address.service.CityService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindCitiesByStateId implements BaseUseCase<List<City>, Long> {
    
    private final CityService cityService;

    @Override
    public List<City> perform(Long stateId) {
        return cityService.findByStateId(stateId);
    } 
}
