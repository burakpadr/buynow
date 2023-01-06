package com.padr.buynow.outbound.iyzipay.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "integration.iyzipay")
@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IyzipayProperty {

    private String baseUrl;
    private String apiKey;
    private String apiSecret;
}
