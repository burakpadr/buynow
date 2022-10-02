package com.padr.buynow.outbound.countrystatecity.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "integration.country-state-city")
@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryStateCityProperty {
    
    private String apiAuthenticationAlias;
    private String apiAuthenticationValue;
}
