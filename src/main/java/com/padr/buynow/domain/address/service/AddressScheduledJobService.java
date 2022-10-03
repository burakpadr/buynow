package com.padr.buynow.domain.address.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.City;
import com.padr.buynow.domain.address.entity.Country;
import com.padr.buynow.domain.address.entity.State;
import com.padr.buynow.outbound.countrystatecity.client.CountryStateCityClient;
import com.padr.buynow.outbound.countrystatecity.model.CountryResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressScheduledJobService {

    private final CountryStateCityClient countryStateCityClient;

    private final CountryService countryService;
    private final StateService stateService;
    private final CityService cityService;

    public void refreshAddressCache() {
        deleteOldAddressCache();

        List<Country> countries = saveCountriesToCacheAndGet();

        countries.parallelStream().forEach(country -> {
            List<State> states = saveStatesToCacheAndGet(country);

            states.parallelStream().forEach(state -> {
                saveCitiesToCache(country, state);
            });
        });
    }

    private void deleteOldAddressCache() {
        countryService.deleteAll();
        stateService.deleteAll();
        cityService.deleteAll();
    }

    private List<Country> saveCountriesToCacheAndGet() {
        List<Country> countries = countryStateCityClient.getCountries().parallelStream().map(CountryResponse::to)
                .collect(Collectors.toList());

        countryService.saveAll(countries);

        return countries;
    }

    private List<State> saveStatesToCacheAndGet(Country country) {
        List<State> states = countryStateCityClient.getStatesByCountryIso(country.getIso()).parallelStream()
                .map(stateResponse -> {
                    State state = stateResponse.to();

                    state.setCountryId(country.getId());

                    return state;
                }).collect(Collectors.toList());

        stateService.saveAll(states);

        return states;
    }

    private void saveCitiesToCache(Country country, State state) {
        List<City> cities = countryStateCityClient
                .getCitiesByCountryIsoAndStateIso(country.getIso(), state.getIso()).parallelStream()
                .map(cityResponse -> {
                    City city = cityResponse.to();

                    city.setStateId(state.getId());

                    return city;
                }).collect(Collectors.toList());

        cityService.saveAll(cities);
    }
}
