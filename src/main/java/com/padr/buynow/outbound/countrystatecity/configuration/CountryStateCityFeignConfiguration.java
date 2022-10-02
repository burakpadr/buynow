package com.padr.buynow.outbound.countrystatecity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.padr.buynow.outbound.countrystatecity.property.CountryStateCityProperty;

import feign.RequestInterceptor;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CountryStateCityFeignConfiguration {

    private final CountryStateCityProperty countryStateCityProperty;

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(countryStateCityProperty.getApiAuthenticationAlias(),
                    countryStateCityProperty.getApiAuthenticationValue());
        };
    }
}
