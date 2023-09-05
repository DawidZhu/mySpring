package com.example.mynotificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * http://localhost:15672
 * brew services start rabbitmq
 *
 * 简单模式(Hello World)
 * 做最简单的事情，一个生产者对应一个消费者，RabbitMQ相当于一个消息代理 Broker ，负责将A的消息转发给B。
 *
 * 单生产者，单消费者，单队列。
 * Work Queues 模式
 * 消息队列是RabbitMQ的内部对象，用于存储生产者的消息直到发送给消费者，它是消费者接收消息的地方。
 * 在多个消费者之间分配任务(竞争的消费者模式)，一个生产者对应多个消费者。
 * 适用于资源密集型任务， 单个消费者处理不过来，需要多个消费者进行处理的场景。
 *
 * 单生产者，多消费者，单队列。
 * 消息队列的重要属性:
 * 持久性： broker重启前都有效。
 * 自动删除：在所有消费者停止使用之后自动删除。
 * 惰性：没有主动声明队列，调用会导致异常。
 * 排他性：-一旦启用，声明它的消费者才能使用。
 *
 *  Publish/Subscribe 模式
 *   使用 TopicExchange，routingkey 必须用多个单词的列表
 *   一次向许多消费者发送消息，将消息将广播到所有的消费者。
 *   单生产者，多消费者，多队列。
 *   应用场景：更新商品库存后需要通知多个缓存和多个数据库。
 *
 *   主题模式(Topics)：
 *   主题交换机方式接收消息，将routing key和模式进行匹配。
     多消费者，选择性多队列，每个队列通过模式匹配。
     队列需要绑定在一个模式上。
     匹配一个词或多个词，*只匹配一个词。
 */
@SpringBootApplication
@Slf4j
public class MyNotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyNotificationServiceApplication.class, args);
    }

    /**
     * RabbitListener 指定接收消息的 queues
     */
    @RabbitListener(queues = "simple.queue")
    public void handleNotification(String orderNumber){
        // send out an email notification
        log.info("handleNotification, orderNumber: " + orderNumber);
        log.info("从消息队列 queues， 收到异步消息 RabbitMQ， 准备发送email 给下单的客户");

    }


}
