package com.cfets.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class CmsSystemController {
    private static final Logger logger= LoggerFactory.getLogger(CmsSystemController.class);


    //跳转到login页面
    @RequestMapping(value = "/login")
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }



}
