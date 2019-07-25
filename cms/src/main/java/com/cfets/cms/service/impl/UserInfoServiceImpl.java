package com.cfets.cms.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.cfets.cms.mapper.UserInfoMapper;
import com.cfets.cms.model.UserInfo;
import com.cfets.cms.service.UserInfoService;
import com.cfets.cms.util.ResultMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger= LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo queryUserInfoById(String userId) {

        UserInfo info=userInfoMapper.queryUserInfoById(userId);
        return info;
    }

    @Override
    public List<UserInfo> queryUserInfo(UserInfo userInfo) {
        return userInfoMapper.queryUserInfo(userInfo);
    }

    @Override
    public PageInfo<UserInfo> queryListInfo(UserInfo userInfo ,int pageNum,int  pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //查询分页页面表格数据
        List<UserInfo> list= userInfoMapper.queryUserInfo(userInfo);
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);

        //查询分页页面 分页栏数据
       int tatal= userInfoMapper.getTotal(userInfo);
       int pages=(tatal+pageSize-1)/pageSize;//总页数
        pageInfo.setPages(pages);
        pageInfo.setPageNum(pageNum);
        return pageInfo;
    }

    @Override
    public Map<String, Object> updateById(UserInfo userInfo) {
        Map<String, Object> map;
        try {
            userInfoMapper.updateById(userInfo);
            logger.info("用户信息更新成功");
            map= ResultMapUtil.success("用户信息更新成功");
        }catch (Exception e){
            logger.error("更新用户信息系统错误");
            e.printStackTrace();
            map= ResultMapUtil.fail("更新用户信息系统错误");
        }

        return map;
    }


    @Override
    public Map<String, Object> deleteById(String userId) {
        Map<String, Object> map;
        try {
            if(StringUtils.isEmpty(userId)){
                map= ResultMapUtil.fail("删除用户信息系统错误,用户ID丢失");
                logger.info("删除用户信息系统错误,用户ID丢失");
                return map;
            }
            userInfoMapper.deleteById(userId);
            logger.info("用户信息删除成功");
            map= ResultMapUtil.success("用户信息删除成功");
        }catch (Exception e){
            logger.error("删除用户信息系统错误");
            e.printStackTrace();
            map= ResultMapUtil.fail("删除用户信息系统错误");
        }
        return map;
    }

    @Override
    public Map<String, Object> addUserInfo(UserInfo userInfo) {
        Map<String, Object> map;
        try {
            userInfoMapper.addUserInfo(userInfo);
            logger.info("用户信息新增成功");
            map= ResultMapUtil.success("用户信息新增成功");
        }catch (Exception e){
            logger.error("新增用户信息系统错误");
            e.printStackTrace();
            map= ResultMapUtil.fail("新增用户信息系统错误");
        }
        return map;
    }


}
