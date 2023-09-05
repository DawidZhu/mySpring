package com.example.eureka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka server
 * Service registration and discovery
 * 分为 服务端和客户端，所有微服务(消费者和提供者)都作为客户端 client 注册到 Eureka的服务端Server（注册中心）
 *
 * Nacos:
 * EurekaServer 同样可以通过Nacos 实现
 * 步骤：下载安装包，解压，启动，pom引入nacos.discovery 依赖，配置nacos-server地址
 *
 * Service registration and discovery
 * 服务注册功能
 *
 * 此App 为eureka 服务端，直接启动就可以
 * 注意检查pom 不要引入过多依赖，如:mybatis，否则就算不启用，也会检查mapper文件！！！
 */
@EnableEurekaServer  //打开开关
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication.class,args);
    }
}
