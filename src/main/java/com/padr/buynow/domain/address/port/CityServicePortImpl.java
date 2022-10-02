package com.padr.buynow.domain.address.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.address.entity.City;
import com.padr.buynow.domain.address.service.CityService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CityServicePortImpl implements CityServicePort {

    private final CityService cityService;

    @Override
    public List<City> findByStateId(Long stateId) {
        return cityService.findByStateId(stateId);
    }
    
}
