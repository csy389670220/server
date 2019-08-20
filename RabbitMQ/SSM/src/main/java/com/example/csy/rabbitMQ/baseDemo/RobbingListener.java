package com.example.csy.rabbitMQ.baseDemo;

import com.example.csy.entity.UserEntity;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author jay.zhou
 * @date 2019/4/25
 * @time 11:07
 */
@Component
@RabbitListener(queues = {"${defineProps.rabbit.direct.queue}"})
public class RobbingListener {


    private static final Logger LOGGER = LoggerFactory.getLogger(RobbingListener.class);

    @RabbitHandler
    public void receiver(@Payload UserEntity msg, @Headers Channel channel, Message message) throws IOException {
        LOGGER.info("接收到的消息:{}", msg);
        try {
            //模拟处理非核心业务需要3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            LOGGER.info("确认处理消息:{}", msg);
        } catch (Exception e) {
            LOGGER.error("消费处理异常:{} - {}", msg, e);
            // 拒绝当前消息，并把消息返回原队列(最后一个参数为true),false则忽略这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }
}