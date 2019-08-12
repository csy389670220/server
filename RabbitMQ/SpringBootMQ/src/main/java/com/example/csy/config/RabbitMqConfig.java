package com.example.csy.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *提供者对应消费者模式
 */
@Configuration
public class RabbitMqConfig {
    public static final String QUEUE_NAME_A = "queueA";
    public static final String QUEUE_NAME_B = "queueB";
 
    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_NAME_A);
    }
 
    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_NAME_B);
    }
}