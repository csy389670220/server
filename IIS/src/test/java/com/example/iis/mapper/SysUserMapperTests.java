package com.example.iis.mapper;

import com.example.iis.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserMapperTests {

    @Autowired
    SysUserMapper sysUserMapper;
    @Test
    public void contextLoads() {
        SysUser userInfo= sysUserMapper.selectByLoginName("admin");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userInfo);
    }

}
