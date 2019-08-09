package com.example.csy.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueB")
public class ReceiverB {
 
    private Logger logger = LoggerFactory.getLogger("ReceiverB");
 
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("接收者B号获取到数据" + msg);
    }
}