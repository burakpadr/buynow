package com.padr.buynow.outbound.redis.address.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.padr.buynow.domain.address.entity.City;

@Repository
public interface CityCacheRepository extends CrudRepository<City, Long> {
    
    List<City> findByStateId(Long stateId);
}
