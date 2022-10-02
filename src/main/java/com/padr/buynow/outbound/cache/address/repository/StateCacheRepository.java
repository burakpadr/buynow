package com.padr.buynow.outbound.cache.address.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.address.entity.State;

@Repository
public interface StateCacheRepository extends CrudRepository<State, Long> {

    List<State> findByCountryId(Long countryId);
}
