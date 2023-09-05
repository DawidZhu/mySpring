package com.example;



import org.junit.jupiter.api.Test;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * AMQP (Advanced Message Queuing Protocol) is an application layer protocol for messaging middleware.
 * Spring AMQP是一个基于AMQP协议的消息中间件框架，它提供了一个简单的API来发送和接收异步、可靠的消息。
 * 它是Spring框架的一部分，可以与Spring Boot和其他Spring项目一起使用。
 * Spring AMQP支持多种消息协议，包括RabbitMQ、Apache ActiveMQ和Qpid等。
 * Spring AMQP还提供了一些高级特性，如消息转换器、消息路由、消息过滤和消息拦截等。
 * Work Queues 模式： 一个publisher， 一个queue，多个 Consumer 来抢消息
 * Publish/Subscribe 模式： 一个publisher， 中间一个exchange，同时把消息转发到多个queue，多个 Consumer 都可以读到
 * Topic 模式： 一个publisher， 中间一个exchange，根据routingkey 把消息route到对应的queue，对应的 Consumer才可以读到
 *
 */
@EnableRabbit
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage(){
        String queueName = "simple.queue";
        String message = "hello, spring AMQP";
        rabbitTemplate.convertAndSend(queueName, message);

    }

    /**
     * http://localhost:15672
     * topic 模式
     * Topic exchange : 根据配置的规则Routing key & queue，把不同的topic转发到对应的Queue,
     * exchangeType = topic，支持通配符
     */
    @Test
    public void testSendTopicExchange(){
        //交换机名称
        String exchangeName = "example.topic";
        //消息
        String message = "hello,from David ";

        //发送 object 类型消息
        Map<String, Object> msg = new HashMap<>();
        msg.put("name","David");
        msg.put("age", 30);

        rabbitTemplate.convertAndSend(exchangeName,"david.news", msg);
        rabbitTemplate.convertAndSend(exchangeName,"china.hello", msg);
    }

}
