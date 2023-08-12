package com.nseed.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NseedProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NseedProductApiApplication.class, args);
	}
	 
}
