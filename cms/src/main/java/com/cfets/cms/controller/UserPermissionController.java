package com.cfets.cms.controller;

import com.cfets.cms.error.EmBusinessError;
import com.cfets.cms.model.vo.RoleVo;
import com.cfets.cms.service.UserPermissionService;
import com.cfets.cms.util.ResultMapUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 *  系统用户权限管理控制类
 */
@Controller
@ResponseBody
@RequestMapping("userPer")
public class UserPermissionController extends BaseController {
    private static final Logger logger= LoggerFactory.getLogger(UserPermissionController.class);

    @Autowired
    UserPermissionService userPermissionService;

    //跳转到UserPermission业务页面
    @RequestMapping(value = "/query")
    @RequiresPermissions("role_per_query")
    public ModelAndView query(RoleVo roleVo) {
        ModelAndView modelAndView = new ModelAndView("userPer/userPermission");
        roleVo.setPageSize(PAGESIZE);
        Map<String,Object> result=userPermissionService.selectRole(roleVo);
        modelAndView.addObject("result",result);
        modelAndView.addObject("role",roleVo);
        return modelAndView;
    }



    @RequestMapping(value = "/treeInit")
    public ModelAndView treeInit(RoleVo roleVo) {
        ModelAndView modelAndView = new ModelAndView("userPer/tree");
        Map<String,Object> perList=userPermissionService.selectAllPer(roleVo);
        modelAndView.addObject("result",perList);
        return modelAndView;
    }

    @RequestMapping(value = "/add")
    @RequiresPermissions("role_per_add")
    public  Map<String,Object> addRole(RoleVo roleVo) {
        Map<String,Object> result;
        try {
             result=userPermissionService.addRole(roleVo);
        } catch (Exception e) {
            logger.error("addRole系统错误");
            result= ResultMapUtil.build(EmBusinessError.ROLE_PERMISSION_ADD_ERROR);
    }
        return result;
    }

    @RequestMapping(value = "/del")
    @RequiresPermissions("role_per_del")
    public  Map<String,Object> delRole(RoleVo roleVo) {
        Map<String,Object> result;
        try {
            result=userPermissionService.delRole(roleVo);
        } catch (Exception e) {
            logger.error("delRole系统错误");
            result= ResultMapUtil.build(EmBusinessError.ROLE_PERMISSION_DEL_ERROR);
        }
        return result;
    }

    @RequestMapping(value = "/update")
    @RequiresPermissions("role_per_update")
    public  Map<String,Object> updateRole(RoleVo roleVo) {
        Map<String,Object> result;
        try {
            result=userPermissionService.updateRole(roleVo);
        } catch (Exception e) {
            logger.error("updateRole系统错误");
            result= ResultMapUtil.build(EmBusinessError.ROLE_PERMISSION_UPDATE_ERROR);
        }
        return result;
    }




}
