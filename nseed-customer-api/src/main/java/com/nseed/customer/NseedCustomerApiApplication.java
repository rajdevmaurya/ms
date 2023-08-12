package com.nseed.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NseedCustomerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NseedCustomerApiApplication.class, args);
	}
	 
}
