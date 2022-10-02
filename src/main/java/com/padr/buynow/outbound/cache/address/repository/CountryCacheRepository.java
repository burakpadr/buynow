package com.padr.buynow.outbound.cache.address.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.address.entity.Country;

@Repository
public interface CountryCacheRepository extends CrudRepository<Country, Long>{
}
