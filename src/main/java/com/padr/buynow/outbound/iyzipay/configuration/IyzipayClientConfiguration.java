package com.padr.buynow.outbound.iyzipay.configuration;

import com.iyzipay.Options;
import com.padr.buynow.outbound.iyzipay.property.IyzipayProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class IyzipayClientConfiguration {

    private final IyzipayProperty iyzipayProperty;

    @Bean
    public Options iyzipayOptions() {
        Options options = new Options();

        options.setBaseUrl(iyzipayProperty.getBaseUrl());
        options.setApiKey(iyzipayProperty.getApiKey());
        options.setSecretKey(iyzipayProperty.getApiSecret());

        return options;
    }
}
