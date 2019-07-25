package com.cfets.cms.mapper;

import com.cfets.cms.model.Permission;
import com.cfets.cms.model.vo.PermissionVo;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<PermissionVo> selectAllPer(PermissionVo record);
}