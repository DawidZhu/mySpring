package com.example.myspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * 1. Spring MVC
 * View视图层(->映射配置->)Controller控制层(->IOC容器->)Model业务层
 *
 * 2. IOC:Inversion of control
 *  控制反转，使用对象时，由主动New 产生对象转换为由外部IOC容器提供对象，此过程中对象创建控制权由程序转移到外部。
 *  不再需要new userdao()，而是在DaoImpl中将UserDao 组件到IOC 容器中(通过@Repository 注解完成)，
 *  在service层使用自动装配 注解 @Autowired，即可获得 IOC 容器中的Bean
 *
 *  3. DI: Dependency Injection
 *   依赖注入，在容器中建立bean 与 bean之间依赖关系的整个过程
 *   @ Autowired，自动装配  即可注入 IOC 容器中的Bean，Service 依赖 Dao
 *
 *  @ Service 注册Bean, for Service layer，通常和业务有关
 *  @ Component 注册Bean，组件，通常和业务无关，通用的工具类
 *
 * 4. AOP : Aspect Oriented Programing
 *  作用：在不惊动原始设计的基础上为其进行功能增强
 *  Spring理念：无入侵式/无侵入式
 *  JointPoint:程序执行过程中的任意位置，在SpringAOP中理解为方法的执行
 *  PointCut: 匹配连接点的式子
 *  Advice：在切入点处执行的操作，也就是共性功能
 *  Aspect：描述通知与切入点的关系
 *  通过注解实现 Aspect，需要写代码练习.......
 *  Aspects enable the implementation of crosscutting concerns such as- transaction,
 *  logging not central to business logic without cluttering the code core to its functionality.
 *  For example- Security is a crosscutting concern, in many methods in an application security rules
 *  can be applied, therefore repeating the code at every method, define the functionality
 *  in a common class and control were to apply that functionality in the whole application.
 *
 *  5.Autowired
 *  自动导入依赖的bean对象，默认时按照byType方式导入对象，
 *  自动装配，从IOC容器中取 bean. 一层一层的根据依赖导入bean
 *  Qualifier("") 必须配合Autowired 使用，获取指定名称的bean
 *
 *  6.@Service
 *  通常用于修饰serviceimpl 层的组件，声明一个对象，会将类对象实例化并注入到bean容器里面。
 *
 *  @ SpringBootApplication
 *  SpringBoot 通过依赖管理 & 自动配置,简化Spring 环境搭建、开发
 *  = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
 *
 *  MapperScan
 *  在SpringBoot中集成MyBatis，可以在mapper接口上添加@Mapper注解，将mapper注入到Spring,
 *  但是如果每一给mapper都添加@mapper注解会很麻烦，这时可以使用@MapperScan注解来扫描包。
 *  @ MapperScan注解只会扫描包中的接口，不会扫描类
 */

// @MapperScan("com.example.mySpring.mapper") // 用于代替每个接口上的Mapper注解
@SpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
         //SpringApplication.run(MySpringBootApplication.class, args);

        //1,return IOC container
        ConfigurableApplicationContext run = SpringApplication.run(MySpringBootApplication.class, args);

        //2. get component of container
        String[]  names = run.getBeanDefinitionNames();
		for(String name : names){
			System.out.println("Bean: "+ name);
		}
    }

}
