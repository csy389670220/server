package com.example.csy.controller;

import com.example.csy.entity.UserEntity;
import com.example.csy.rabbitMQ.RobbingSender;
import com.example.csy.service.SsmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基础demo类
 */
@Controller
@ResponseBody
public class SsmController {
    private Logger logger= LoggerFactory.getLogger(SsmController.class);
    @Autowired
    RobbingSender robbingSender;

    @Autowired
    SsmService ssmService;

    @RequestMapping("/get")
    public String toSend(long id) {
        UserEntity userEntity = new UserEntity(id, " xiaoming", 22);
        robbingSender.sendRobbingMessage(userEntity);
        return "hello";
    }

    @RequestMapping("/syn")
    public String synchronizeHandle(){
        long startTime=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            ssmService.synchronizeService();
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        logger.info("synchronizeHandle程序运行时间:{}ms",endTime-startTime);
        return "syn";
    }

    @RequestMapping("/asyn")
    public String asynchronousHandle(){
        long startTime=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            ssmService.asynchronizeService();
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        logger.info("synchronizeHandle程序运行时间:{}ms",endTime-startTime);
        return "asyn";
    }
}
