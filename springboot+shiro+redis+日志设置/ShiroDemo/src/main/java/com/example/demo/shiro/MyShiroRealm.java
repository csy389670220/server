package com.example.demo.shiro;

import com.example.demo.controller.IndexController;
import com.example.demo.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger logger= LoggerFactory.getLogger(MyShiroRealm.class);
    //如果项目中用到了事物，@Autowired注解会使事物失效，可以自己用get方法获取值

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.debug("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        // 从数据库获取对应用户名密码的用户
        SysUser userList = new SysUser();
        userList.setUserName(name);
        userList.setPassword("b9f912ca2a9aeffde7a0468b7cb660a1");
        if (userList != null) {
            logger.debug("---------------- Shiro 凭证认证开始 ----------------------");
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    userList.getUserName(), //用户名
                    userList.getPassword(), //密码
                    ByteSource.Util.bytes("cms"),//盐值
                  "MyShiroRealm"
            );
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.debug("---------------- 执行 Shiro 权限获取 ---------------------");
        // 根据用户名来查询数据库赋予用户角色,权限（查数据库）
        String loginName = (String)SecurityUtils.getSubject().getPrincipal();
        // String loginName= (String) SecurityUtils.getSubject().getSession().getAttribute("loginName");
        logger.debug("授权loginName:{}",loginName);
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        if("admin".equals(loginName)){
            permissions.add("add");
        }else if("user".equals(loginName)){
            permissions.add("del");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        info.setStringPermissions(permissions);
        return info;
    }

}
