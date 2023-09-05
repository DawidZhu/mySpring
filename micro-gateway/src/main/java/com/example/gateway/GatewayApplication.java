package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * gateway也需要注册到 Eureka
 * EnableEurekaClient
 *
 * gateway 的作用：
 * 1，对请求用户身份认证，权限校验
 * 2，将用户请求路由到微服务（根据yml配置的规则，从eureka 获取服务地址），并实现负载均衡
 * 3，对用户请求做限流
 *
 * 功能：
 * 路由断言(Predicates)Route Predicates Factory: After,Before,Header,Host,Method...
 * 路由过滤器(Filters) Gateway Filter Factory : AddRequestHeader, AddRequestParameter
 *
 * 自定义镜像：DockerFile
 * 步骤：1，新建空目录，新建Dockerfile文件
 *      2，springdemo.jar 放到这个目录
 *      3，编写Dockerfile:
 *          From java:8-alpine # 作为基础镜像
 *          COPY ./springdemo.jar   /tmp/app.jar  # 将springdemo.jar 拷贝到镜像
 *          Expose 8090       #暴露端口
 *          ENTRYPOINT  java -jar /tmp/app.jar  #编写入口EntryPoint
 *       4, 使用docker build 命令构建镜像
 *       5， docker run 创建容器并运行
 *
 *  DockerCompose
 *  基于Compose文件帮我们快速的部署分布式应用，而无需手动一个个创建运行容器
 *  一个Compose文本文件包含version,
 *  services(eureka,mysql,userservice,orderservice,gateway的服务名称和对应的dockerfile的地址)
 *  其实就是整合了所有Dockerfile 的单个创建
 *  使用 docker-compose up -d 命令，# 创建并启动容器
 *  docker-compose logs -f 查看日志
 *  docker-compose restart gateway userservive orderservice # 重启对应的服务
 *
 *
 */
@SpringBootApplication
@EnableEurekaClient //开启 EurekaClient
public class GatewayApplication {
    public static void main(String[] args){

        SpringApplication.run(GatewayApplication.class,args);
    }

}
