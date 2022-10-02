package com.padr.buynow.domain.address.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.Country;
import com.padr.buynow.domain.address.entity.State;
import com.padr.buynow.domain.address.exception.StateNotFoundException;
import com.padr.buynow.outbound.redis.address.port.StateCachePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StateService {
    
    private final StateCachePort stateCachePort;

    private final CountryService countryService;

    public State findById(Long id) {
        return stateCachePort.findById(id).orElseThrow(StateNotFoundException::new);
    }

    public List<State> findByCountryId(Long countryId) {
        Country country = countryService.findById(countryId);

        return stateCachePort.findByCountryId(country.getId());
    }

    public void saveAll(List<State> states) {
        stateCachePort.saveAll(states);
    }

    public void deleteAll() {
        stateCachePort.deleteAll();
    }
}
