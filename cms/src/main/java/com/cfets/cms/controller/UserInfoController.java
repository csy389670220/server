package com.cfets.cms.controller;

import com.cfets.cms.model.UserInfo;
import com.cfets.cms.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 用户人像信息维护类
 */
@Controller
@ResponseBody
@RequestMapping("userInfo")
public class UserInfoController extends BaseController {
    private static final Logger logger= LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserInfoService userInfoService;





    /**
     * userInfo初始化查询渲染
     * @param userInfo 用户查询信息
     */
    @RequestMapping(value = "/query")
    @RequiresPermissions(value={"userInfo_query"})
    public ModelAndView query(UserInfo userInfo){
        ModelAndView modelAndView = new ModelAndView("userInfo/userInfo");
        logger.info(userInfo.toString());

        //首次初始化查询，pageNum固定为1
        PageInfo<UserInfo> pageInfo =userInfoService.queryListInfo(userInfo,1,PAGESIZE);

        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("userName",userInfo.getUserName());//查询回显
        modelAndView.addObject("pageNum",1);
        return  modelAndView;
    }


    /**
     * 页面分页查询
     * @param userName  用户名
     * @param page     当前页码
     * @return
     */
    @RequiresPermissions(value={"userInfo_query"})
    @RequestMapping(value = "/queryList")
    public ModelAndView queryList(@RequestParam("userName") String userName,@RequestParam("page") int page){
        ModelAndView modelAndView = new ModelAndView("userInfo/userInfoTable");
        logger.info("queryList userName:{},page:{}",userName,page);
        PageHelper.startPage(page,PAGESIZE);
        List<UserInfo> list =userInfoService.queryUserInfo(
                new UserInfo("",userName,"","","","",""));

        modelAndView.addObject("pageInfo",list);
        return  modelAndView;
    }

    /**
     * 查询用户信息
     * @param userId  用户ID
     * @return
     */
    @RequestMapping(value = "/queryUserInfoById")
    public UserInfo queryUserInfoById(@RequestParam("userId") String userId){
        logger.info("queryUserInfoById  userId:{}",userId);
        UserInfo info=userInfoService.queryUserInfoById(userId);

        return info;
    }


    /**
     * 根据用户信息更新表信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/updateById")
    public Map<String, Object> updateById(UserInfo userInfo){
        logger.info("updateById:{}",userInfo.toString());
        Map<String, Object> map=userInfoService.updateById(userInfo);

        return map;
    }

    /**
     * 根据用户信息删除表信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteById")
    public Map<String, Object> deleteById(@RequestParam("userId") String userId){
        logger.info("deleteById  userId:{}",userId);
        Map<String, Object> map=userInfoService.deleteById(userId);
        return map;
    }

    /**
     * 新增用户资源
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/addUserInfo")
    public Map<String, Object> addUserInfo(UserInfo userInfo){
        logger.info("addUserInfo:{}",userInfo.toString());
        Map<String, Object> map=userInfoService.addUserInfo(userInfo);
        return map;
    }

}
