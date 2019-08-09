package com.example.csy.mq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
 
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {
    private Logger logger = LoggerFactory.getLogger("TopicReceiver2");
 
    @RabbitHandler
    public void process(String msg) {
        System.out.println("接收者2号接收到信息:" + msg);
    }
}