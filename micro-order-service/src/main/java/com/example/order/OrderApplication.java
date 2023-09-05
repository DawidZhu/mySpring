package com.example.order;


import com.example.feign.clients.UserFeignClient;
import com.example.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation .Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Micro Service
 *
 * is an architecture that allows the developers to develop and deploy services independently.
 * Each service running has its own process and this achieves the lightweight model to
 * support business applications.
 *  microservice style 微服务模块开发：
 * 1.建Module， 2.改POM（依赖），3.写YML，4.主启动，5.业务类
 * 所有的微服务都应该有SpringBootApplication主程序入口
 *
 * 2.monolithic style
 *   Microservice 拆分原则：
 *    1，不同微服务不要开发相同功能；
 *    2，微服务的数据独立，不要访问其他微服务的数据库；
 *    3，微服务可以将自己的业务暴露为接口，供其他微服务调用
 *   服务调用关系：一个服务可以同时是服务提供者和服务消费者
 *
 *   Ribbon 负载均衡
 *  1, 规则接口IRule
 *  2，默认实现是ZoneAvoidanceRule,轮询加载 Round Robin
 *
 * 属于配置类
 * Bean的注入只能放到配置类
 * 1. RestTemplate方式：远程调用
 *
 * 2. FeignClients  远程调用
 * 添加注解：EnableFeignClients
 *
 * 3。Feign 连接优化
 *  使用 HttpClient 代替默认的 UrlConnection, 因为有连接池功能
 *  Feign的作用
 * 是将Http请求抽象化为一个Interface客户端，可以调用接口的形式来执行Http请求，以达到简化Http调用的目的。
 *
 */
@MapperScan("com.example.order.mapper")
@SpringBootApplication //默认的扫描包是启动类所在的包 com.example.order
//开启feign的自动化功能，通过JAVA代码配置Logger

//启动类添加注解，开始自动装配开关, 添加默认包以外的类,指定需要的包
@EnableFeignClients(clients = UserFeignClient.class, defaultConfiguration = DefaultFeignConfiguration.class)

public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 服务发现
     * 1，引入依赖；2，配置地址；3，加LoadBalanced; 4,使用serverName调用
     * RestTemplate方式：远程调 用功能
     * 创建RestTemplate 并注入Spring IOC 容器
     *
     *  Ribbon 负载均衡
     *
     * 拦截所有http请求，从eureka 获取server注册的url，根据规则选择url访问
     * LoadBalanced : 实现负载均衡, 通过Ribbon实现，默认为轮训规则
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 设置负载均衡规则为 随机
     * @return
     */
//    @Bean
//    public IRule randomRule(){
//        return new RandomRule();
//    }



}