package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@ResponseBody
public class SysController {
    private static final Logger logger= LoggerFactory.getLogger(SysController.class);



    //跳转到login页面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView submitLogin(String username, String password) {
        ModelAndView view ;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            logger.debug("本次登录sessionId:{},username:{}",subject.getSession().getId().toString(),username);
            subject.login(token);
            //SysUser user = (SysUser) subject.getPrincipal();
        } catch (DisabledAccountException e) {
            logger.info("用户不存在");
            view = new ModelAndView("login");
            return view;
        } catch (AuthenticationException e) {
            logger.info("用户验证错误");
            view = new ModelAndView("login");
            return view;
        }
        // 执行到这里说明用户已登录成功
        subject.getSession().setAttribute("loginName", username);//可以是用户ID，或者唯一标示
        view = new ModelAndView("index");
        view.addObject("username",username);
        return view;
    }



    //跳转到首页面
    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView("login");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        logger.info("系统安全退出");
        return modelAndView;
    }






}
