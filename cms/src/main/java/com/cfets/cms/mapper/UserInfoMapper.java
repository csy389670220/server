package com.cfets.cms.mapper;


import com.cfets.cms.model.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserInfoMapper {
	 UserInfo queryUserInfoById(String userId);//根据用户ID查询用户信息

	 List<UserInfo> queryUserInfo(UserInfo userInfo);//查询绑定用户基础信息

	int getTotal(UserInfo userInfo);//查询数据总数

	void updateById(UserInfo info);//根据ID更新用户信息

	void deleteById(String userId);//根据ID删除用户信息

	void addUserInfo(UserInfo userInfo);// 新增userInfo

}