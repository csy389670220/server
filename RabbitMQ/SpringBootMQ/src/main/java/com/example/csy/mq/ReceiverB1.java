package com.example.csy.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueB")
public class ReceiverB1 {
 
    private Logger logger = LoggerFactory.getLogger("ReceiverB1");
 
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("接收者B1号获取到数据" + msg);
    }
}