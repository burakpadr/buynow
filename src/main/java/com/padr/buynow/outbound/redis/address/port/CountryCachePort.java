package com.padr.buynow.outbound.redis.address.port;

import java.util.List;
import java.util.Optional;

import com.padr.buynow.domain.address.entity.Country;

public interface CountryCachePort {

    public List<Country> findAll();

    public Optional<Country> findById(Long id);

    public void saveAll(List<Country> countries);

    public void deleteAll();
}
