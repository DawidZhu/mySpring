package com.example.productservice;

import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  brew services list;
 *  brew services start mongodb-community
 *
 *
 */
@SpringBootApplication
@EnableEurekaClient // EurekaClient
public class ProductServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);


    }

}
