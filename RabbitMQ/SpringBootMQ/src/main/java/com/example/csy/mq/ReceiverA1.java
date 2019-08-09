package com.example.csy.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueA")
public class ReceiverA1 {
 
    private Logger logger = LoggerFactory.getLogger("ReceiverA1");
 
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("接收者A1获取到数据" + msg);
    }
}