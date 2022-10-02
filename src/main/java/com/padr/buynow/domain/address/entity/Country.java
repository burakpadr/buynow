package com.padr.buynow.domain.address.entity;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("country")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    
    private Long id;
    private String name;
    private String iso;
}
