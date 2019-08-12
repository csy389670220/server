package com.example.csy.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "send")
    public void send(){
        String message = "Hello world";
        String receiverA = "queueA";
        for(int i=0;i<1000;i++){
            amqpTemplate.convertAndSend(receiverA, message);
        }
        System.out.println("队列结束");
    }
}
