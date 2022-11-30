package com.padr.buynow.domain.core.address.port;

import java.util.List;

import com.padr.buynow.domain.core.address.entity.Country;

public interface CountryServicePort {
    
    public List<Country> findAllCountries();
}
