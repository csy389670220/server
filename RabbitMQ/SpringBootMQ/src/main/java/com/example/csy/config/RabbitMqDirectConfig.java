package com.example.csy.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Direct Exchange
 */

@Configuration
public class RabbitMqDirectConfig {

    /**
     * directA队列名
     */
    final String QUEUE_NAME_A = "directA";

    /**
     * directB队列名
     */
    final String QUEUE_NAME_B = "directB";

    /**
     * 初始化一个叫directA的队列
     */
    @Bean
    public Queue queueDirectA() {
        return new Queue(QUEUE_NAME_A);
    }

    /**
     * 初始化一个叫directB的队列
     */
    @Bean
    public Queue queueDirectB() {
        return new Queue(QUEUE_NAME_B);
    }



    /**
     * 创建一个叫directExchange的路由器
     * 路由器负责分发消息到指定的队列
     */
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");//配置广播路由器
    }



    /**
     * 约定大于配置
     * 这个方法的参数queueA就是本类中queueA()方法的返回值
     * 这个方法的参数directExchange就是本类中exchange()方法的返回值
     */
    @Bean
    public Binding bindingDirectExchangeA(Queue queueDirectA,DirectExchange directExchange) {
        return BindingBuilder.bind(queueDirectA).to(directExchange).with("beauty");
    }

    /**
     * 约定大于配置
     * 这个方法的参数queueB就是本类中queueB()方法的返回值
     * 这个方法的参数directExchange就是本类中exchange()方法的返回值
     */
    @Bean
    public Binding bindingDirectExchangeB(Queue queueDirectB,DirectExchange directExchange) {
        return BindingBuilder.bind(queueDirectB).to(directExchange).with("food");
    }
}
