package com.padr.buynow.domain.address.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.City;
import com.padr.buynow.domain.address.entity.State;
import com.padr.buynow.outbound.redis.address.port.CityCachePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityService {
    
    private final CityCachePort cityCachePort;

    private final StateService stateService;

    public List<City> findByStateId(Long stateId) {
        State state = stateService.findById(stateId);

        return cityCachePort.findByStateId(state.getId());
    }

    public void saveAll(List<City> cities) {
        cityCachePort.saveAll(cities);
    }

    public void deleteAll() {
        cityCachePort.deleteAll();
    }
}
