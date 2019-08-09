package com.example.csy.mq.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "directB")
public class DirectReceiver2 {
    private Logger logger = LoggerFactory.getLogger("DirectReceiver2");
 
    @RabbitHandler
    public void process(String msg) {
        System.out.println("direct接收者2号接收到信息:" + msg);
    }
}