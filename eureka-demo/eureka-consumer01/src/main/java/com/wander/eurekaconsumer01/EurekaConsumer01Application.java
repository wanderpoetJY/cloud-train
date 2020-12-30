package com.wander.eurekaconsumer01;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class EurekaConsumer01Application {

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}

//	@Bean
//	RandomRule randomRule(){return  new RandomRule();}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumer01Application.class, args);
	}

}
