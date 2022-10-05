package com.padr.buynow.inbound.common.configuration;

import org.hashids.Hashids;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.padr.buynow.inbound.common.property.HashidsProperty;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class HashidsConfiguration {
    
    private final HashidsProperty hashidsProperty;

    @Bean
    public Hashids hashids() {
        return new Hashids(hashidsProperty.getSalt(), hashidsProperty.getMinimumHashLength());
    }
}
