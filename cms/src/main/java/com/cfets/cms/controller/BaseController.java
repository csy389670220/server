package com.cfets.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * CMS系统基础控制类
 * 项目页面业务分2个分支
 * A分支：正常登陆看到的，页面启用全部刷新。每点一次菜单栏都会刷新页面。以welcome.html为入口，页面sql对应oracle
 * B分支：正常登陆之后需要手动输入地址http://localhost:8088/CMS/index，采用局部刷新，即点击菜单栏不刷新。以index.html为入口
 * 正常登陆默认展示A分支 2019.7.8。
 * 正常登陆默认展示B分支  2019.7.10
 */
@Controller
@ResponseBody
public class BaseController implements Serializable {
    private static final Logger logger= LoggerFactory.getLogger(BaseController.class);

    public static  final int PAGESIZE=5;//分页查询，页面条目数量





}
