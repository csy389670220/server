package com.example.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;


@Controller
@ResponseBody
public class BaseController implements Serializable {
    private static final Logger logger= LoggerFactory.getLogger(BaseController.class);
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi")
    public String  home(String  name){
        return "hi "+name+",i am from port:" +port;
    }



}
