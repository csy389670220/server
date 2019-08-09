package com.example.csy.mq.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanoutB")
public class FanoutReceiver2 {
    private Logger logger = LoggerFactory.getLogger("FanoutReceiver2");
 
    @RabbitHandler
    public void process(String msg) {
        System.out.println("fanout接收者2号接收到信息:" + msg);
    }
}