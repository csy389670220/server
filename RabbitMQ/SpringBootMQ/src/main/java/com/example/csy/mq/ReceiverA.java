package com.example.csy.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queueA")
public class ReceiverA {
 
    private Logger logger = LoggerFactory.getLogger("ReceiverA");
 
    @RabbitHandler
    public void receiver(String msg) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("接收者A获取到数据" + msg);
    }
}