package com.cfets.cms.service;

import com.cfets.cms.model.vo.RoleVo;

import java.util.Map;

public interface UserPermissionService {
    /**
     * 根据查询条件，查询role信息集合
     * @param roleVo
     * @return
     */
    Map<String,Object> selectRole(RoleVo roleVo);


    /**
     * 查询系统所有资源集合
     * @param roleVo
     * @return
     */
    Map<String,Object> selectAllPer(RoleVo roleVo);

    /**
     * 新增角色
     * @param roleVo
     * @return
     * @throws Exception
     */
    Map<String,Object> addRole(RoleVo roleVo) throws Exception;


    /**
     * 删除角色
     * @param roleVo
     * @return
     * @throws Exception
     */
    Map<String,Object> delRole(RoleVo roleVo) throws Exception;


    /**
     * 跟更新角色
     * @param roleVo
     * @return
     * @throws Exception
     */
    Map<String,Object>  updateRole (RoleVo roleVo) throws Exception;
}
