package com.example.csy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;


@Controller
@ResponseBody
public class BaseController implements Serializable {
    private static final Logger logger= LoggerFactory.getLogger(BaseController.class);
    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String getHi(String name){
        return  restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }


    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
