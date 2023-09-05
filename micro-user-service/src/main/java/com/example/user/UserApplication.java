package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 主启动类，SpringBoot的入口
 *
 * 服务注册步骤：
 *  1，pom 引eureka依赖； 2，yml 配置地址
 *
 */
@MapperScan("com.example.user.mapper")
@SpringBootApplication

public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
