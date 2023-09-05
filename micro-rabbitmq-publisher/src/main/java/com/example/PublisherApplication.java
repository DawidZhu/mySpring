package com.example;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

/**
 * brew services list;
 * brew services start rabbitmq     //start
 * brew services stop  rabbitmq     //stop
 * brew services restart rabbitmq   //restart
 *
 * Publish/Subscribe 模式
 *  使用 TopicExchange，routingkey 必须用多个单词的列表
 *  http://localhost:15672
 *
 *
 */
@SpringBootApplication
public class PublisherApplication {
    public static void main(String[] args){
        SpringApplication.run(PublisherApplication.class);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }


}
