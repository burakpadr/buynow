package com.padr.buynow.outbound.redis.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisProperty {
    
    private String host;
    private Integer port;
}
