package com.cfets.cms;

import com.cfets.cms.mapper.SysUserMapper;
import com.cfets.cms.model.Permission;
import com.cfets.cms.model.SysUser;
import com.cfets.cms.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * SysUserService业务层测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void selectByLoginName() {
        Map<String,Object> sysUserMap = sysUserService.selectByLoginName("admin");
        SysUser sysUser= (SysUser) sysUserMap.get("data");
        System.out.println("selectByLoginName>>>>>>>>" + sysUser.getId() + "|" + sysUser.getUserName() + "|" + sysUser.getLoginName() + "|" + sysUser.getPassword());
    }


    @Test
    public void selectAllPermission(){
       List<Permission> list= sysUserMapper.selectAllPermission("zhangsan");
       for(Permission p:list){
           System.out.println(p.getPerCode()+":"+p.getPerDesc());
       }
    }

}
