package com.example.myorderservice.service;

import com.example.myorderservice.dto.InventoryResponse;
import com.example.myorderservice.dto.OrderLineItemsDto;
import com.example.myorderservice.dto.OrderRequest;
import com.example.myorderservice.event.OrderPlacedEvent;
import com.example.myorderservice.model.Order;
import com.example.myorderservice.model.OrderLineItems;
import com.example.myorderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @ Transactional注解
 *
 * 可以作用于接口（不建议）、类以及类public 方法上。
 * 当作用于类上时，该类的所有 public 方法将都具有该类型的事务属性
 * 原子性(Atomicity)，一致性(Consistency)，隔离性(Isolation)
 * 声明式事务: 基于AOP,有助于用户将操作与事务规则进行解耦。其本质是对方法前后进行拦截，
 * 然后在目标方法开始之前创建或者加入一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务。
 * 显然声明式事务管理要优于编程式事务管理，这正是spring倡导的非侵入式的开发方式。
 * 声明式事务管理使业务代码不受污染，一个普通的POJO对象，只要加上注解就可以获得完全的事务支持。
 *
 * WebClient可以发送异步Web请求，并支持响应式编程。
 * WebClient is a non-blocking reactive. Feign is blocking.
 * Spring WebClient
 * is a non-blocking reactive client to make HTTP requests.
 * Hence if you intend to use Spring Reactive Stream API to
 * stream data asynchronously then this is the way to go.
 * Think event-driven architecture. WebClient is part of the Spring WebFlux library.
 *
 * Feign
 * is a declarative REST library that uses annotations based architecture with
 * thread-per-request model. This means that the thread will block until the feign client
 * receives the response. The problem with the blocking code is it must wait until
 * the consuming thread completes, hence think memory and CPU cycles.
 */
@Service
@Transactional //Spring 声明式事务管理，建立在AOP之上的
@Slf4j
public class OrderService  {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // RabbitMQ
    String queueName = "simple.queue";
    //交换机名称
    String exchangeName = "example.topic";

    /**
     * 通过WebClient发起异步请求，WebClient返回Mono结果
     *
     * 创建订单，同时webClient 调用Inventory Microservice 去查是否在库存
     * 从 orderRequest 中取出 List
     * 操作List, 通过 stream().map
     * map() 方法接收的是一个 Function（Java 8 的一个函数式接口，接受一个输入参数 T，返回一个结果 R）类型的参数
     * Function<T,R>: 函数型接口
     * 抽象方法： R apply(T t)，传入一个参数，返回想要的结果。
     */
    public String placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                // 从request 获取 DTO List, 用stream().map 操作 DTO List，完成ItemsDto 到 Items 的映射
                // 返回 OrderLineItems
                .stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto))
                .collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItemsList);
        //获取order里面 所有skuCode List
        // 对List中的每个元素做操作，方式： List().Stream().Map()；操作后又返回List，通过collect()
       List<String> skuCodes = order.getOrderLineItemsList()
               // 重写方法，map中执行 orderLineItems.getSkuCode()
               .stream().map(orderLineItems -> orderLineItems.getSkuCode()
                ).collect(Collectors.toList());
       log.info("skuCodes>>>>" + skuCodes.toString());

        // 调用Microservice  Call Inventory Service
        // 传入参数 List 类型的skuCode
        InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
                .uri("http://inventory-service:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                // Mono与Flux是Spring Reactor提供的异步数据流。
                .bodyToMono(InventoryResponse[].class) // 反射 reflect 指定对象类型
                .block();

        log.info("inventoryResponseArray>>>> "+ inventoryResponseArray);
       // 对数组操作，Arrays.stream(), allMatch()都满足某个条件，返回ture
        // allMatch(Predicate<? super T> var1)
        Boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
                .allMatch(inventoryResponse -> inventoryResponse.isInStock());

        if(allProductsInStock){
            //如果存在库存，下单
            orderRepository.save(order);
            // 下单成功后，RabbitMQ 异步消息通知
            // convertAndSend(String exchange, String routingKey, Object object)
            //rabbitTemplate.convertAndSend(exchangeName, "order.number", new OrderPlacedEvent(order.getOrderNumber()));
            rabbitTemplate.convertAndSend(queueName, order.getOrderNumber());
            return "Order Placed Successfully!";
        }else {
            throw new IllegalArgumentException("Product is not in Stock!");
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return  orderLineItems;
    }
}
