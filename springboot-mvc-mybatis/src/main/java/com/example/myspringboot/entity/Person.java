package com.example.myspringboot.entity;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取 YAML
 * 1. @ConfigurationProperties
 *
 *  通常会一次性读取一个 Java 配置类，然后在需要使用的地方直接引用这个类就可以多次访问了，方便维护
 *  首先，在application.yml文件里定义参数变量。
 *  然后，创建一个 Java 配置类，将参数变量注入即可!
 *  容器中的组件 Bean 才会有Spring 容器提供的功能
 *
 *  2.@Component
 *  泛指组件，当组件不好归类的时候，可以使用这个注解进行标注，功能类似于于@Service。
 *
 *  3.lombok
 *  @ Data // 自动生成get set方法
 *  @ AllArgsConstructor // 生成有参构造函数
 *  @ NoArgsConstructor  // 生成无参构造函数
 *  @ ToString // 生成 toString 方法
 *  @ Slf4j //log
 *  @ Builder：用在类、构造器、方法上，为你提供复杂的builder APIs
 */
@ConfigurationProperties(prefix = "person") //从配置文件读取，person 下的数据
@Component //注入到IOC容器 Bean
@ToString
@Data  // 自动生成get set方法
@Slf4j //log
public class Person {
    private String userName;
    private boolean boss;
    private int age;
    private String[] interests;

}
