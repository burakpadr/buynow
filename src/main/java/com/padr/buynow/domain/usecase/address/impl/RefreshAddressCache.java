package com.padr.buynow.domain.usecase.address.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.Country;
import com.padr.buynow.domain.core.address.entity.State;
import com.padr.buynow.domain.core.address.service.CityService;
import com.padr.buynow.domain.core.address.service.CountryService;
import com.padr.buynow.domain.core.address.service.StateService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RefreshAddressCache implements BaseUseCase<Void, Void> {

    private final CountryService countryService;
    private final StateService stateService;
    private final CityService cityService;

    @Override
    public Void perform(Void v) {
        deleteOldAddressCache();

        List<Country> countries = countryService.createCountriesAndGet();

        countries.parallelStream().forEach(country -> {
            List<State> states = stateService.saveStatesAndGet(country);

            states.parallelStream().forEach(state -> {
                cityService.saveCitiesAndGet(country, state);
            });
        });

        return null;
    }

    private void deleteOldAddressCache() {
        countryService.deleteAll();
        stateService.deleteAll();
        cityService.deleteAll();
    }
}
