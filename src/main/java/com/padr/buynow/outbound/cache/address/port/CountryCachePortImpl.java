package com.padr.buynow.outbound.cache.address.port;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.address.entity.Country;
import com.padr.buynow.outbound.cache.address.repository.CountryCacheRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CountryCachePortImpl implements CountryCachePort {

    private final CountryCacheRepository countryCacheRepository;

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();

        countryCacheRepository.findAll().iterator().forEachRemaining(countries::add);

        return countries;
    }

    @Override
    public void saveAll(List<Country> countries) {
        countryCacheRepository.saveAll(countries);
    }

    @Override
    public void deleteAll() {
        countryCacheRepository.deleteAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryCacheRepository.findById(id);
    }
}
