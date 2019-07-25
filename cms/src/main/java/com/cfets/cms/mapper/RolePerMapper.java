package com.cfets.cms.mapper;

import com.cfets.cms.model.RolePer;

import java.util.List;

public interface RolePerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePer record);

    int insertSelective(RolePer record);

    RolePer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePer record);

    int updateByPrimaryKey(RolePer record);

    int deleteByRoleID(Integer id);

    List<RolePer> selectByRoleId(Integer roleId);
}