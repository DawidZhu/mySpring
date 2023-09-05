package com.example.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Work Queues 模式： 一个publisher， 一个queue，多个 Consumer 来抢消息
 * Publish/Subscribe 模式： 一个publisher， 中间一个exchange，同时把消息转发到多个queue，多个 Consumer 都可以读到
 * Topic 模式： 一个publisher， 中间一个exchange，根据routingkey 把消息route到对应的queue，对应的 Consumer才可以读到
 *
 * http://localhost:15672
 *
 *  Topic 模式，使用 TopicExchange，
 *   routingkey 必须用多个单词的列表
 *
 */
@Component
public class SpringRabbitListener {

    /**
     * Work Queues 模式： 一个publisher， 一个queue，多个 Consumer 来抢消息
     */
 @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg){
     System.out.println("listenSimpleQueue: " + msg);
 }

    /**
     * listenTopicQueue1
     * Topic 模式，绑定exchange，Queue，routingkey
     */
 @RabbitListener(bindings = @QueueBinding(
         value = @Queue(name = "topic.queue1"),
         exchange = @Exchange(name = "example.topic", type = ExchangeTypes.TOPIC),
         key = "china.#"
 ))
 public void listenTopicQueue1(Map<String, Object> msg){
    System.out.println("listen Topic Queue1: " + msg);

}

    /**
     * listenTopicQueue2
     * Topic 模式，绑定exchange，Queue，routingkey
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "example.topic", type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void listenTopicQueue2( Map<String, Object> msg){
        System.out.println("listen Topic Queue2: " + msg);

    }
}
