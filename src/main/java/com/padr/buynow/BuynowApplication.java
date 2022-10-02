package com.padr.buynow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableRedisRepositories
public class BuynowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuynowApplication.class, args);
	}

}
