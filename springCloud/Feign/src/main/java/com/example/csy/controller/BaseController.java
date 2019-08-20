package com.example.csy.controller;

import com.example.csy.service.FeifnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BaseController {
    @Autowired
    FeifnService feifnService;

    @RequestMapping(value = "/hi")
    public String sayHi(String name){
        return feifnService.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "/verification")
    public String verification(){
        return feifnService.verification("程思雨","","","");
    }
}
