package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
@ResponseBody
public class IndexController {
    private static final Logger logger= LoggerFactory.getLogger(IndexController.class);

    private static String loginName;
    @ModelAttribute
    public void init(){
        if("".equals(loginName)||loginName==null){
            logger.debug("IndexController init session");
            loginName= (String) SecurityUtils.getSubject().getSession().getAttribute("loginName");
        }
        logger.info("IndexController session-loginName-{}",loginName);
    }

    //跳转到index页面
    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("index");
        view.addObject("username",loginName);
        return view;
    }

    //跳转到index页面
    @RequestMapping(value = "/index1")
    public ModelAndView index1(){
        ModelAndView view = new ModelAndView("index1");
        view.addObject("username",loginName);
        return view;
    }

    //跳转到index页面
    @RequestMapping(value = "/index2")
    public ModelAndView index2(){
        ModelAndView view = new ModelAndView("index2");
        view.addObject("username",loginName);
        return view;
    }


    //跳转到index页面
    @RequestMapping(value = "/call")
    public String   getSession(){
        String  loginName= (String) SecurityUtils.getSubject().getSession().getAttribute("loginName");
        return loginName;
    }
}
