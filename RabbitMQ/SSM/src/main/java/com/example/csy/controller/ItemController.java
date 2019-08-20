package com.example.csy.controller;

import com.example.csy.rabbitMQ.RabbitMQConfig;
import com.example.csy.rabbitMQ.RobbingSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品下单交易类
 */
@Controller
@ResponseBody
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private RobbingSender robbingSender;


    @RequestMapping("/dead")
    public void test() {
        String msg="死信队列来啦";
        robbingSender.sendItemMessage(msg);
    }

}
