package com.padr.buynow.domain.address.port;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.address.entity.Country;
import com.padr.buynow.domain.address.service.CountryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CountryServicePortImpl implements CountryServicePort {
    
    private final CountryService countryService;

    @Override
    public List<Country> findAllCountries() {
        return countryService.findAllCountries();
    }
}
