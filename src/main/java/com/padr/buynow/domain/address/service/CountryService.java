package com.padr.buynow.domain.address.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.Country;
import com.padr.buynow.domain.address.exception.CountryNotFoundException;
import com.padr.buynow.outbound.countrystatecity.client.CountryStateCityClient;
import com.padr.buynow.outbound.countrystatecity.model.CountryResponse;
import com.padr.buynow.outbound.redis.address.port.CountryCachePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {
    
    private final CountryCachePort countryCachePort;

    private final CountryStateCityClient countryStateCityClient;

    public List<Country> createCountriesAndGet() {
        List<Country> countries = countryStateCityClient.getCountries().parallelStream().map(CountryResponse::to)
        .collect(Collectors.toList());

        countryCachePort.saveAll(countries);

        return countries;
    }

    public List<Country> findAllCountries() {
        return countryCachePort.findAll();
    }

    public Country findById(Long id) {
        return countryCachePort.findById(id).orElseThrow(CountryNotFoundException::new);
    }

    public void deleteAll() {
        countryCachePort.deleteAll();
    }
}
