package com.example.csy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout Exchange
 */

@Configuration
public class RabbitMqFanoutConfig {

    /**
     * fanoutA队列名
     */
    final String QUEUE_NAME_A = "fanoutA";

    /**
     * fanoutB队列名
     */
    final String QUEUE_NAME_B = "fanoutB";

    /**
     * 初始化一个叫fanoutA的队列
     */
    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_NAME_A);
    }

    /**
     * 初始化一个叫fanoutB的队列
     */
    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_NAME_B);
    }



    /**
     * 创建一个叫fanoutExchange的路由器
     * 路由器负责分发消息到指定的队列
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");//配置广播路由器
    }



    /**
     * 约定大于配置
     * 这个方法的参数queueA就是本类中queueA()方法的返回值
     * 这个方法的参数fanoutExchange就是本类中fanoutExchange()方法的返回值
     */
    @Bean
    public Binding bindingFanoutExchangeA(Queue queueA,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    /**
     * 约定大于配置
     * 这个方法的参数queueB就是本类中queueB()方法的返回值
     * 这个方法的参数fanoutExchange就是本类中fanoutExchange()方法的返回值
     */
    @Bean
    public Binding bindingFanoutExchangeB(Queue queueB,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }
}
