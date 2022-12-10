package com.padr.buynow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.core.RedisKeyValueAdapter.EnableKeyspaceEvents;

@SpringBootApplication
@EnableFeignClients
@EnableRedisRepositories(enableKeyspaceEvents = EnableKeyspaceEvents.ON_STARTUP)
public class BuynowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuynowApplication.class, args);
	}

}
