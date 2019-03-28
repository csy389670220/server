package com.cfets.cms.realms;

import com.cfets.cms.model.User;
import com.cfets.cms.model.UserResourceResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

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

	/*@Autowired
	@Qualifier("authService")
	AuthService authService;*/

	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		// 将AuthenticationToken强转为AuthenticationToken对象
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		// 获得从表单传过来的用户信息
		String username = upToken.getUsername();
		Object credentials =upToken.getPassword();

        //TODO  模拟数据库根据用户名查询数据库正确的user
		User userInfo=new User("110","admin","21232F297A57A5A743894A0E4A801FC3","20180111000000","");
		if(userInfo==null){
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				userInfo, //用户名
				userInfo.getPassWord(), //密码
				getName()  //realm name
		);

		return authenticationInfo;
	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


		// 从PrincipalCollection中获得用户信息
		Object principal = principals.getPrimaryPrincipal();
		String uid= (String) SecurityUtils.getSubject().getSession().getAttribute("uid");
		//TODO userId查询用户授权信息，此处模拟
		List<UserResourceResult> list=new ArrayList<UserResourceResult>() ;

		// 根据用户名来查询数据库赋予用户角色,权限（查数据库）
		Set<String> roles = new HashSet<>();
		Set<String> permissions = new HashSet<>();
		/*for(UserResourceResult re:list){
			permissions.add(re.getResourceInfo().getResourceCode());
		}*/
		//TODO userId查询用户授权信息，此处模拟
		permissions.add("userInfo_query");
		permissions.add("userInfo_add");
		permissions.add("userInfo_del");
		permissions.add("userInfo_update");

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		//添加权限
		info.setStringPermissions(permissions);
		return info;
	}


}