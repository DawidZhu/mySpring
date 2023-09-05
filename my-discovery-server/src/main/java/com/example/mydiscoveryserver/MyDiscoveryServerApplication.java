package com.example.mydiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer  // EnableEurekaServer
@SpringBootApplication
public class MyDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDiscoveryServerApplication.class, args);
	}

}
