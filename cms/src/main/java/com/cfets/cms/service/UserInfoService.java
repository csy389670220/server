package com.cfets.cms.service;

import com.cfets.cms.model.UserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    /**
     * 根据用户ID查询用户详细信息
     * @param userId  用户ID
     * @return
     */
    UserInfo queryUserInfoById(String userId);

    /**
     * //查询绑定用户基础信息
     * @param userInfo
     * @return
     */
    List<UserInfo> queryUserInfo(UserInfo userInfo);

    /**
     * 查询页面分页信息详细
     * @param userInfo  查询关键信息
     * @param pageNum   当前页码
     * @param pageSize  当前页面显示的数据条目
     * @return
     */
    PageInfo<UserInfo>  queryListInfo(UserInfo userInfo,int pageNum,int  pageSize);

    /**
     * 根据ID 更新用户信息
     * @param userInfo
     * @return
     */
    Map<String, Object> updateById(UserInfo userInfo);

    /**
     * 根据用户ID删除信息
     * @param userId
     * @return
     */
    Map<String, Object>  deleteById(String userId);


    /**
     * 新增userInfo用户
     * @param userInfo
     */
    Map<String, Object> addUserInfo(UserInfo userInfo);
}
