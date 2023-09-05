package com.example.myorderservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // EurekaClient
@EnableRabbit
public class MyOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOrderServiceApplication.class, args);
	}

}
