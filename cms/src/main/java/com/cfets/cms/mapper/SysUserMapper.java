package com.cfets.cms.mapper;

import com.cfets.cms.model.Permission;
import com.cfets.cms.model.SysUser;
import com.cfets.cms.model.vo.SysUserVo;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByLoginName(String loginName);//根据登录名查询数据

    List<SysUser> selectSysUsers(SysUserVo record);//根据查询条件查询列表

    int getTotal(SysUserVo record);//查询数据总数

    List<Permission> selectAllPermission(String  loginName);//根据登录名，查询用户所有权限
}