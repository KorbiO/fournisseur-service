package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport (type = {EnableHypermediaSupport.HypermediaType.HAL})
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class RestFournisseurServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFournisseurServiceApplication.class, args);
	}
	
	
}
