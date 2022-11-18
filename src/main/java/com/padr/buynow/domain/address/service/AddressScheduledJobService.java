package com.padr.buynow.domain.address.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.Country;
import com.padr.buynow.domain.address.entity.State;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressScheduledJobService {

    private final CountryService countryService;
    private final StateService stateService;
    private final CityService cityService;

    public void refreshAddressCache() {
        deleteOldAddressCache();

        List<Country> countries = countryService.createCountriesAndGet();

        countries.parallelStream().forEach(country -> {
            List<State> states = stateService.saveStatesAndGet(country);

            states.parallelStream().forEach(state -> {
                cityService.saveCitiesAndGet(country, state);
            });
        });
    }

    private void deleteOldAddressCache() {
        countryService.deleteAll();
        stateService.deleteAll();
        cityService.deleteAll();
    } 
}
