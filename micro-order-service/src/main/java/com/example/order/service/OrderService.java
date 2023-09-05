package com.example.order.service;


import com.example.feign.clients.UserFeignClient;
import com.example.feign.model.User;
import com.example.order.mapper.OrderMapper;
import com.example.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  1.RestTemplate 发起http请求，查询用户.
 *  userservice已注册到 eureka，使用服务名称 userservice
 *  Rest Template is used to create applications that consume RESTful Web Services.
 *
 *  2.Eureka
 * 服务注册和发现
 *
 *  3.Feign
 *  是一个申明式的客户端，作用是帮助我们优雅的实现HTTP请求的发送
 *  Feign通过 Ribbon 实现负载均衡
 *  WebClient is a non-blocking reactive. Feign is blocking.
 *
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    /**
     * 自动装配，Feign 接口
     */
    @Autowired
    UserFeignClient userFeignClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // http://localhost:8081/user/1
        //2.利用RestTemplate 发起http请求，查询用户. 已注册到 eureka，使用服务名称 userservice
        //String url = "http://userserver/user/" + order.getUserId();
        //User user = restTemplate.getForObject(url, User.class);

        // 2. 另一种方式，用Feign远程调用， 需要 引入抽取后的feign api 依赖
        // WebClient is a non-blocking reactive. Feign is blocking.

        User user = userFeignClient.findUserById(order.getUserId());

        //3.封装user 到Order
        order.setUser(user);

        // 4.返回
        return order;
    }
}
