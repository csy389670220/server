package com.cfets.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;

/**
 * CMS系统基础控制类
 */
@Controller
@ResponseBody
public class CmsSystemController  implements Serializable {
    private static final Logger logger= LoggerFactory.getLogger(CmsSystemController.class);

    public int pageSize=5;//分页查询，页面条目数量





}
