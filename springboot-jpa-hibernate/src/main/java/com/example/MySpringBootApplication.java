package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * SpringBoot 通过依赖管理 & 自动配置,简化Spring 环境搭建、开发
 * = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
 *
 * Spring Data可以让我们只定义接口，只要遵循spring data的规范，就无需写实现类，不用写sql语句直接查询数据
 *
 */

@SpringBootApplication
public class MySpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(MySpringBootApplication.class, args);
	}

}
