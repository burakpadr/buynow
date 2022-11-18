package com.padr.buynow.domain.address.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.City;
import com.padr.buynow.domain.address.entity.Country;
import com.padr.buynow.domain.address.entity.State;
import com.padr.buynow.outbound.countrystatecity.client.CountryStateCityClient;
import com.padr.buynow.outbound.redis.address.port.CityCachePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityCachePort cityCachePort;

    private final StateService stateService;

    private final CountryStateCityClient countryStateCityClient;

    public List<City> saveCitiesAndGet(Country country, State state) {
        List<City> cities = countryStateCityClient
                .getCitiesByCountryIsoAndStateIso(country.getIso(), state.getIso()).parallelStream()
                .map(cityResponse -> {
                    City city = cityResponse.to();

                    city.setStateId(state.getId());

                    return city;
                }).collect(Collectors.toList());

        cityCachePort.saveAll(cities);

        return cities;
    }

    public List<City> findByStateId(Long stateId) {
        State state = stateService.findById(stateId);

        return cityCachePort.findByStateId(state.getId());
    }
    
    public void deleteAll() {
        cityCachePort.deleteAll();
    }
}
