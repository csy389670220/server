package com.cfets.cms.mapper;

import com.cfets.cms.model.Role;
import com.cfets.cms.model.vo.RoleVo;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<RoleVo> selectRole(RoleVo record);

    int getTotal(RoleVo record);
}