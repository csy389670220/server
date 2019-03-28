package com.cfets.cms.controller;

import com.cfets.cms.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * CMS系统登录类
 */
@Controller
@ResponseBody
public class loginController  extends CmsSystemController{

    //跳转到login页面
    @RequestMapping(value = "/login")
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    //跳转到首页面
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        //modelAndView.addObject("countryList", dataList);

        return modelAndView;
    }

    //跳转到首页面
    @RequestMapping(value = "/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("welcome");
        //modelAndView.addObject("countryList", dataList);

        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView loginUser(@RequestParam("userName") String userName,
                                  @RequestParam("passWord") String passWord,
                                  HttpSession session)
    {
        ModelAndView modelAndView ;
        // 初始化这个用户的token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);

        // 获取事件的主体
        Subject subject = SecurityUtils.getSubject();
        // 设置超时时间5分钟
        subject.getSession().setTimeout(5*60*1000);
        subject.getSession().setAttribute("uid","110");//可以是用户ID，或者唯一标示
        try
        {
            // 尝试登录
            subject.login(token);

            // 获取用户的全部信息
            User user = (User) subject.getPrincipal();

            // 用于界面输出
            session.setAttribute("user", user);
            modelAndView = new ModelAndView("welcome");
            return modelAndView;
        }
        catch (Exception e)
        {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("loginInfo","loginError");
            return modelAndView;
        }
    }

}


