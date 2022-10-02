package com.padr.buynow.domain.address.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.address.entity.Country;
import com.padr.buynow.domain.address.exception.CountryNotFoundException;
import com.padr.buynow.outbound.cache.address.port.CountryCachePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {
    
    private final CountryCachePort countryCachePort;

    public List<Country> findAllCountries() {
        return countryCachePort.findAll();
    }

    public Country findById(Long id) {
        return countryCachePort.findById(id).orElseThrow(CountryNotFoundException::new);
    }

    public void saveAll(List<Country> countries) {
        countryCachePort.saveAll(countries);
    }

    public void deleteAll() {
        countryCachePort.deleteAll();
    }
}
