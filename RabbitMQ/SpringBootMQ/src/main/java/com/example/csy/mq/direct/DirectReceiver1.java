package com.example.csy.mq.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "directA")
public class DirectReceiver1 {
    private Logger logger = LoggerFactory.getLogger("DirectReceiver1");
 
    @RabbitHandler
    public void process(String msg) {
        System.out.println("direct接收者1号接收到信息:" + msg);
    }
}