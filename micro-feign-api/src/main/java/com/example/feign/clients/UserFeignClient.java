package com.example.feign.clients;


import com.example.feign.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign的作用
 * 是将Http请求抽象化为一个Interface客户端，可以调用接口的形式来执行Http请求，以达到简化Http调用的目的。
 * FeignClient HTTP客户端接口
 * 将FeignClient 、Model、Feign的默认配置都定义到一个项目中，供所有消费者使用。
 *
 * 发起远程调用使用  http://localhost:8081/user/1  ， http://userserver/user/1
 * Feign通过Ribbon实现负载均衡
 *
 * Feign性能优化：
 * 1，使用连接池的 Apache HttpClient ；2，使用loglevel 为Basic
 *
 * 底层的客户端实现，默认使用 URLConnection,不支持连接池
 * 推荐使用Apache HttpClient :支持连接池
 *
 * Feign的使用步骤：
 * 1，引入依赖
 * 2，添加 @ EnableFeignClients注解
 * 3，编写FeignClient接口
 * 4，使用FeignClient中定义的方法代替RestTemplate
 *
 * ribbon 是一个负载均衡客户端，可以很好的控制http和tcp的一些行为。
 * feign默认集成了ribbon。
 *
 * FeignClient 代码结构和RestController GetMapping很像
 * Feign 是一个声明式的 Web 服务，通过定义一个添加相应注解的接口，即可完成一个 Web 服务的接口。
 *
 * 作为依赖 Jar 提供给 OrderServer 使用
 */

@FeignClient("userserver") //调用目标 server name
public interface UserFeignClient {

    /**
     * 发送请求的参数
     * 声明式客户端，findUserById() 不需要实现
     * 因为： Feign作为HttpClient 直接请求 userserver 的 RestController，通过GetMapping,url,PathVariable
     */
    @GetMapping("/user/{id}")  //请求服务路径&参数,指向userserver
    // 返回类型
    User findUserById(@PathVariable("id") Long id);

}
