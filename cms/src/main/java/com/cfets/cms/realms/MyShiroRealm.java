package com.cfets.cms.realms;

import com.cfets.cms.mapper.SysUserMapper;
import com.cfets.cms.model.Permission;
import com.cfets.cms.model.SysUser;
import com.cfets.cms.model.UserResourceResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * realm实现类,用于实现具体的验证和授权方法
 * @author Bean
 *
 */
public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	SysUserMapper sysUserMapper;

	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		// 将AuthenticationToken强转为AuthenticationToken对象
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		// 获得从表单传过来的用户信息
		String loginName = upToken.getUsername();

		SysUser userInfo= sysUserMapper.selectByLoginName(loginName);

		if(userInfo==null){
			throw new UnknownAccountException("不存在该用户");//没找到帐号
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				userInfo, //用户名
				userInfo.getPassword(), //密码
				ByteSource.Util.bytes("cms"),//盐值
				getName()  //realm name
		);

		return authenticationInfo;
	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


		// 从PrincipalCollection中获得用户信息
		Object principal = principals.getPrimaryPrincipal();
		String loginName= (String) SecurityUtils.getSubject().getSession().getAttribute("loginName");
		//loginName查询用户授权信息
		List<Permission> list=sysUserMapper.selectAllPermission(loginName);

		// 根据用户名来查询数据库赋予用户角色,权限（查数据库）
		Set<String> roles = new HashSet<>();
		Set<String> permissions = new HashSet<>();
		for(Permission p:list){
			permissions.add(p.getPerCode());
		}
		/*permissions.add("userInfo_query");
		permissions.add("userInfo_add");
		permissions.add("userInfo_del");
		permissions.add("userInfo_update");*/

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		//添加权限
		info.setStringPermissions(permissions);
		return info;
	}


}