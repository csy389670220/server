package com.cfets.cms.service;

import com.cfets.cms.model.vo.SysUserVo;

import java.util.Map;

public interface SysUserService {
    /**
     * 根据loginName查询系统用户信息
     * @param loginName
     * @return
     */
    Map<String,Object> selectByLoginName(String loginName);

    /**
     * 根据查询条件查询系统用户信息集合
     * @param sysUserVo 查询条件
     * @return
     */
    Map<String,Object> selectSysUsers(SysUserVo sysUserVo);

    /**
     * 新增用户资源
     * @param sysUserVo
     * @return
     */
    Map<String,Object> addSysUsers(SysUserVo sysUserVo) throws Exception;

    /**
     * 查询系统所有有效资源
     * @param sysUserVo
     * @return
     */
    Map<String,Object> selectAllRole(SysUserVo sysUserVo);

    /**
     * 更新用户资源
     * @param sysUserVo
     * @return
     */
    Map<String,Object> updateUser(SysUserVo sysUserVo) throws Exception;

    /**
     * 删除用户
     * @param sysUserVo
     * @return
     * @throws Exception
     */
    Map<String,Object>  delUser (SysUserVo sysUserVo) throws Exception;

}
