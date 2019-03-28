package com.cfets.cms.controller;

import com.alibaba.druid.util.StringUtils;
import com.cfets.cms.model.IdealConfigModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * IDEAL系统环境配置控制类
 */
@Controller
@ResponseBody
@RequestMapping("ideal")
public class IdealSystemController {
    private static final Logger logger= LoggerFactory.getLogger(IdealSystemController.class);


    //跳转到ideal页面
    @RequestMapping(value = "/go")
    public ModelAndView goPage() {
        ModelAndView modelAndView = new ModelAndView("idealConfig");
        return modelAndView;
    }


    /**
     * 查询指定环境变量的ideal系统配置信息
     * @param idealConfigModel  环境参数
     */
    @RequestMapping(value = "/query")
    public ModelAndView queryList(@ModelAttribute IdealConfigModel idealConfigModel){
        ModelAndView modelAndView = new ModelAndView("ideal/idealConfig");
        logger.info("ideal系统查询列表参数:{}",idealConfigModel.getMilieuVal());
        if(StringUtils.isEmpty(idealConfigModel.getMilieuVal())){
            modelAndView.addObject("currentPage",0);
            modelAndView.addObject("totalPages",1);
               return  modelAndView;
        }
        List<IdealConfigModel> idealList=getDB(idealConfigModel.getMilieuVal());
        modelAndView.addObject("milieuVal",idealConfigModel.getMilieuVal());
        modelAndView.addObject("idealList",idealList);
        modelAndView.addObject("currentPage",1);
        modelAndView.addObject("totalPages",10);
        return  modelAndView;
    }

    /**
     * 查询指定环境变量的ideal系统配置信息,ajax查询
     */
    @RequestMapping(value = "/ajaxQuery")
    public ModelAndView ajaxQueryList(@RequestParam String milieuVal,@RequestParam("page") String page){
        logger.info("page:{}",page);
        ModelAndView modelAndView = new ModelAndView("ideal/idealConfigTable");
        List<IdealConfigModel> idealList=getDBAjax(milieuVal);
        modelAndView.addObject("idealList",idealList)  ;
        return modelAndView;
    }


    public List<IdealConfigModel> getDB(String milieuVal){
        List<IdealConfigModel> list=new ArrayList();
        list.add(new IdealConfigModel("1",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("2",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("3",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("4",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("5",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("6",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("7",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("8",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("9",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("10",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));

        return list;

    }

    public List<IdealConfigModel> getDBAjax(String milieuVal){
        List<IdealConfigModel> list=new ArrayList();
        list.add(new IdealConfigModel("1",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("2",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("3",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("4",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        list.add(new IdealConfigModel("5",milieuVal,"及时通讯","SIMSIMT01","111.11.22.33","222.222.22.22","192.168.29.41","0988","user/123456"));
        return list;

    }



}
