package com.padr.buynow.inbound.common.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "hashids")
@Data
public class HashidsProperty {
    
    private String salt; 
    private Integer minimumHashLength;
}
