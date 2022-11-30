package com.padr.buynow.domain.core.address.port;

import java.util.List;

import com.padr.buynow.domain.core.address.entity.City;

public interface CityServicePort {
    
    public List<City> findByStateId(Long stateId);
}
