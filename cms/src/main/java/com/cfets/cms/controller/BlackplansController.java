package com.cfets.cms.controller;

import com.cfets.cms.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 黑板计划
 * B分支页面demo,展示左右布局菜单栏点击局部刷新功能。
 * 用于配合页面模板局部刷新，不做数据库读写。
 * index页面左右布局，点击菜单栏右边局部刷新blackplans业务页面
 */
@Controller
@ResponseBody
@RequestMapping("blackplans")
public class BlackplansController extends BaseController {
    private static final Logger logger= LoggerFactory.getLogger(BlackplansController.class);


    @RequestMapping(value = "/query")
    public ModelAndView query(UserInfo userInfo){
        ModelAndView modelAndView = new ModelAndView("blackplans/blackplans");
        return  modelAndView;
    }

    @RequestMapping(value = "/query1")
    public ModelAndView query1(){
        ModelAndView modelAndView = new ModelAndView("blackplans/blackplans1");
        return  modelAndView;
    }

    @RequestMapping(value = "/query2")
    public ModelAndView query2(){
        ModelAndView modelAndView = new ModelAndView("blackplans/blackplans2");
        return  modelAndView;
    }




}
