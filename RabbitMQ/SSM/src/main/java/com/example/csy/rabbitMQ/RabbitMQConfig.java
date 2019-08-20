package com.example.csy.rabbitMQ;

import com.google.common.collect.Maps;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author jay.zhou
 * @date 2019/4/25
 * @time 10:27
 */
@Configuration
@Getter
public class RabbitMQConfig {
    private Logger logger= LoggerFactory.getLogger(RabbitMQConfig.class);

    /**
     * 交换机名称
     */
    @Value("${defineProps.rabbit.direct.exchange}")
    private String directExchange;

    /**
     * 队列1名称
     */
    @Value("${defineProps.rabbit.direct.queue}")
    private String queue01;

    /**
     * 路由键
     */
    @Value("${defineProps.rabbit.direct.routing.key}")
    private String routingKey;


    /**
     * 订单死信交换机
     */
    @Value("${defineProps.rabbit.direct.dead.exchage}")
    private String deadExchange;

    /**
     * 订单死信队列
     */
    @Value("${defineProps.rabbit.direct.dead.queue}")
    private String deadQueue;

    /**
     *订单死信路由键
     */
    @Value("${defineProps.rabbit.direct.dead.routing.key}")
    private String deadRoutingKey;

    /**
     *订单真实交换机
     */
    @Value("${defineProps.rabbit.direct.produce.exchange}")
    private String produceExchange;


    /**
     *订单真实队列
     */
    @Value("${defineProps.rabbit.direct.real.queue}")
    private String realQueue;

    /**
     *订单死信队列绑定面向生产端的路由键
     */
    @Value("defineProps.rabbit.direct.produce.routing.key")
    private String produceRoutingKey;


    /**
     * 定义交换器
     * 三个参数解释如下
     * name:交换机名称
     * durable:是否持久化，true表示交换机会被写入磁盘，即使RabbitMQ服务器宕机，也能恢复此交换机
     * autoDelete:表示消息交换机没有在使用时将被自动删除 默认是false
     *
     * @return DirectExchange
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directExchange, true, false);
    }


    /**
     * 定义队列01
     * 第一个参数是queue：要创建的队列名
     * 第二个参数是durable：是否持久化。如果为true，可以在RabbitMQ崩溃后恢复队列
     * 第三个参数是exclusive：true表示一个队列只能被一个消费者占有并消费
     * 第四个参数是autoDelete：true表示服务器不在使用这个队列是会自动删除它
     * 第五个参数是arguments：其它参数
     */
    @Bean
    public Queue queue01() {
        return new Queue(queue01, true, false, false, null);
    }


    /**
     * 绑定-将队列绑定到路由器上，队列告诉路由器它感兴趣的话题
     *
     * @param queue01        队列01
     * @param directExchange 交换器
     * @return Binding
     */
    @Bean
    public Binding queue01Binding(Queue queue01, DirectExchange directExchange) {
        return BindingBuilder.bind(queue01).to(directExchange).with(routingKey);
    }






    //第一步：创建死信队列
    @Bean
    public Queue simpleDeadQueue() {
        Map<String, Object> map = Maps.newHashMapWithExpectedSize(5);
        /**
         * 死信队列由死信交换机创建
         * 需要指明死信路由键 以及 消息存活时间
         */
        map.put("x-dead-letter-exchange", deadExchange);
        map.put("x-dead-letter-routing-key", deadRoutingKey);
        map.put("x-message-ttl", 10*1000);
        return new Queue(deadQueue, true, false, false, map);
    }

    //第二步：创建生产端交换机
    @Bean
    public TopicExchange produceExchange() {
        return new TopicExchange(produceExchange, true, false);
    }

    //第三步:创建绑定：死信队列绑定到生产端
    @Bean
    public Binding simpleDeadBinding() {
        return BindingBuilder.bind(simpleDeadQueue()).to(produceExchange()).with(produceRoutingKey);
    }

    //第四步：创建实际的消费队列
    @Bean
    public Queue realQueue() {
        return new Queue(realQueue, true, false, false, null);
    }

    //第五步：创建死信交换机
    @Bean
    public TopicExchange simpleDeadRealExchange(){
        return new TopicExchange(deadExchange, true, false);
    }

    //第六步：将实际队列绑定到死信交换机.路由键使用死信路由键
    @Bean
    public Binding simpleRealDeadBinding(){
        return BindingBuilder.bind(realQueue()).to(simpleDeadRealExchange()).with(deadRoutingKey);
    }




    /**
     * 定义消息转换实例 ，转化成 JSON传输
     *
     * @return Jackson2JsonMessageConverter
     */
    @Bean
    public MessageConverter integrationEventMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}