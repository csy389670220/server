package com.cfets.cms;

import com.cfets.cms.mapper.PermissionMapper;
import com.cfets.cms.mapper.RoleMapper;
import com.cfets.cms.model.vo.PermissionVo;
import com.cfets.cms.model.vo.RoleVo;
import com.cfets.cms.service.UserPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UserPermission业务层测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserPermissionTest {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    UserPermissionService userPermissionService;
    @Test
    public void getTotal() {
        RoleVo vo=new RoleVo();
        int num=roleMapper.getTotal(vo);
        System.out.println("getTotal>>>>>>>>>>>>>"+num);
    }

    @Test
    public void selectRole() {
        RoleVo vo=new RoleVo();
        roleMapper.selectRole(vo);
    }

    @Test
    public void selectAllPer() {
        PermissionVo vo=new PermissionVo();
        vo.setParentId(21);
        vo.setPerLev(2);
        permissionMapper.selectAllPer(vo);
    }

    @Test
    public void selectAllPerService() {
        userPermissionService.selectAllPer(new RoleVo());
    }

    @Test
    public  void addRole(){
        RoleVo vo=new RoleVo();
        vo.setRoleName("测试角色11");
        vo.setRoleDesc("用于角测试11");
        vo.setSysId(3);
        int[] pers1=new int[]{22,23};
        vo.setPermissions(pers1);
        try {
            userPermissionService.addRole(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delRole(){
        RoleVo vo=new RoleVo();
        vo.setId(33);
        vo.setSysId(4);
        try {
            userPermissionService.delRole(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
