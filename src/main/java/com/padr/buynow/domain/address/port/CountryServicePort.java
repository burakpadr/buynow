package com.padr.buynow.domain.address.port;

import java.util.List;

import com.padr.buynow.domain.address.entity.Country;

public interface CountryServicePort {
    
    public List<Country> findAllCountries();
}
