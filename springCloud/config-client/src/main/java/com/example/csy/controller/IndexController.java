package com.example.csy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RefreshScope :刷新功能
 */
@Controller
@ResponseBody
@RefreshScope
public class IndexController {
    @Value("${label}")
    private String label;

    @RequestMapping("/getLabel")
    public String getLabel() {
        return label;
    }
}
