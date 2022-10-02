package com.padr.buynow.domain.address.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("state")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class State {

    @Id
    private Long id;
    private String name;
    private String iso;

    @Indexed
    private Long countryId;
}
