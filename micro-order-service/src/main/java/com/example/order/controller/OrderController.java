package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 * 查询order 订单，同时order server 通过Feign 发送请求到 UserServer查询 user信息
 * http://localhost:8088/order/101
 */
@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;


    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);


    }
}
