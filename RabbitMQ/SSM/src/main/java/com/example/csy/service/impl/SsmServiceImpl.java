package com.example.csy.service.impl;

import com.example.csy.entity.UserEntity;
import com.example.csy.rabbitMQ.RobbingSender;
import com.example.csy.service.SsmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmServiceImpl implements SsmService {
    @Autowired
    RobbingSender robbingSender;

    @Override
    public void synchronizeService() {
        //1.核心业务
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2. 非核心业务
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void asynchronizeService() {
        //1.核心业务
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2. 非核心业务
        robbingSender.sendRobbingMessage(new UserEntity(1L, " xiaoming", 22));
    }
}
