package com.padr.buynow.outbound.redis.address.port;

import java.util.List;

import com.padr.buynow.domain.core.address.entity.City;

public interface CityCachePort {

    public List<City> findByStateId(Long stateId);

    public void saveAll(List<City> cities);

    public void deleteAll();
}
