package com.wander.eurekaconsumer02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EurekaConsumer02Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumer02Application.class, args);
	}

}
