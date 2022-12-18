package com.padr.buynow.domain.usecase.address.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.address.entity.Country;
import com.padr.buynow.domain.core.address.service.CountryService;
import com.padr.buynow.domain.usecase.common.BaseUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAllCountries implements BaseUseCase<List<Country>, Void> {
    
    private final CountryService countryService;

    @Override
    public List<Country> perform(Void v) {
        return countryService.findAllCountries();
    }
}
