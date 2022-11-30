package com.padr.buynow.domain.core.address.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("city")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    private Long id;
    private String name;
    private String iso;

    @Indexed
    private Long stateId;
}
