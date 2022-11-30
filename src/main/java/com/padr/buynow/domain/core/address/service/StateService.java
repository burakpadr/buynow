package com.padr.buynow.domain.core.address.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.address.entity.Country;
import com.padr.buynow.domain.core.address.entity.State;
import com.padr.buynow.domain.core.address.exception.StateNotFoundException;
import com.padr.buynow.outbound.countrystatecity.client.CountryStateCityClient;
import com.padr.buynow.outbound.redis.address.port.StateCachePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateCachePort stateCachePort;

    private final CountryService countryService;

    private final CountryStateCityClient countryStateCityClient;

    public List<State> saveStatesAndGet(Country country) {
        List<State> states = countryStateCityClient.getStatesByCountryIso(country.getIso()).parallelStream()
                .map(stateResponse -> {
                    State state = stateResponse.to();

                    state.setCountryId(country.getId());

                    return state;
                }).collect(Collectors.toList());

        stateCachePort.saveAll(states);

        return states;
    }

    public State findById(Long id) {
        return stateCachePort.findById(id).orElseThrow(StateNotFoundException::new);
    }

    public List<State> findByCountryId(Long countryId) {
        Country country = countryService.findById(countryId);

        return stateCachePort.findByCountryId(country.getId());
    }

    public void deleteAll() {
        stateCachePort.deleteAll();
    }
}
