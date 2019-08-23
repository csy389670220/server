package com.example.iis.controller;

import com.example.iis.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: Farben
 *
 * @description: LoginController-登录业务控制类
 *
 * @create: 2019/8/21-10:24
 **/
@Controller
public class LoginController  extends   BaseController {
    private static final Logger logger= LoggerFactory.getLogger(LoginController.class);
    //跳转到login页面
    @RequestMapping(value = "/login")
    public ModelAndView  login(){
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginUser(@RequestParam("loginName") String loginName,
                                  @RequestParam("passWord") String passWord) {
        ModelAndView modelAndView;

        // 初始化这个用户的token
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, passWord);

        // 获取事件的主体
        Subject subject = SecurityUtils.getSubject();
        // 设置超时时间15分钟
        //subject.getSession().setTimeout(15 * 60 * 1000);
        //subject.getSession().setAttribute("loginName", loginName);//可以是用户ID，或者唯一标示
        try {

            if (!subject.isAuthenticated()) {
                //使用shiro来验证
                token.setRememberMe(true);
                subject.login(token);//验证角色和权限
            }

            // 获取用户的全部信息
            SysUser sysUser = (SysUser) subject.getPrincipal();
            modelAndView = new ModelAndView("index");//正常登录跳转页面
            modelAndView.addObject("loginName", loginName);
            modelAndView.addObject("sysId", sysUser.getId());
            modelAndView.addObject("userName", sysUser.getUserName());
            return modelAndView;
        } catch (IncorrectCredentialsException e) {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("loginErrInfo", "账号密码错误");
            modelAndView.addObject("loginName", loginName);
            logger.info("{}:登录错误，密码匹配错误", loginName);
            return modelAndView;
        } catch (ExcessiveAttemptsException e) {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("loginErrInfo", "登录次数已经超过限制，请一分钟后重试");
            modelAndView.addObject("loginName", loginName);
            logger.info("{}:登录错误，登录次数已经超过限制", loginName);
            return modelAndView;
        } catch (UnknownAccountException e) {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("loginErrInfo", "账号密码错误");
            modelAndView.addObject("loginName", loginName);
            logger.info("{}:登录错误，账号不存在", loginName);
            return modelAndView;
        } catch (Exception e) {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("loginErrInfo", "系统错误，请稍后再试");
            modelAndView.addObject("loginName", loginName);
            logger.info("{}:登录系统错误-{}", loginName,e);
            return modelAndView;
        }
    }


    //跳转到首页面
    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView("welcome");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        logger.info("系统安全退出");
        return modelAndView;
    }


    //跳转到index页面
    @RequestMapping(value = "/index")
    public ModelAndView  index(){
        ModelAndView view = new ModelAndView("index");
        return view;
    }

    //跳转到index页面
    @RequestMapping(value = "/index1")
    public ModelAndView  index1(){
        ModelAndView view = new ModelAndView("index1");
        return view;
    }


}

