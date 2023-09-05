package com.example.myorderservice.controller;

import com.example.myorderservice.dto.OrderRequest;
import com.example.myorderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * http://localhost:8081/actuator
 *
 *  CompletableFuture用于异步编程asynchronous，异步编程是编写非阻塞的代码，运行的任务在一个单独的线程CompletableFuture中，
 *  与主线程隔离，并且会通知主线程它的进度，成功或者失败。
 *
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 下单 endPoint, 创建订单
     * RequestBody 获取Json格式的请求体
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest){
        // 测试 CircuitBreaker 断路器的使用
        //public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
        //supplyAsync()的方法新建另一个线程去执行！！！
        return CompletableFuture.supplyAsync(()-> orderService.placeOrder(orderRequest));

    }

    public CompletableFuture<String>  fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()->"Oops, Somethings went wrong!");

    }
}
