package com.shiro.casclient.app.realm;

import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;

@SuppressWarnings("deprecation")
public class MyCasRealm extends CasRealm {
	
	/*
	 * 只用给用户授权，认证工作CAS服务器完成了。
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String) principals.getPrimaryPrincipal();
		
		//模拟给用户授权
		List<String> roles = new ArrayList<>();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		if (username.equals("admin")) {
			roles.add("admin");
			info.addRoles(roles);
		}
		else{
			roles.add("user");
			info.addRoles(roles);
		}
		
		return info;
	}
}
