package apishop.util;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import apishop.bean.User;
import apishop.service.PermissionService;
import apishop.service.RoleService;
import apishop.service.UserService;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		//能进入到这里，表示账号已经通过验证了
				String userName =(String) principalCollection.getPrimaryPrincipal();
				//通过service获取角色和权限
				Set<String> permissions = permissionService.listPermissions(userName);
				Set<String> roles = roleService.listRoleNames(userName);
				
				//授权对象
				SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
				//把通过service获取到的角色和权限放进去
				s.setStringPermissions(permissions);
				s.setRoles(roles);
				return s;

	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub

		String userName= token.getPrincipal().toString();
		//获取数据库中的密码
		User user =userService.getByName(userName);
		String passwordInDB = user.getPassword();
		String salt = user.getSalt();
        //盐也放进去
        //这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
		SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName,passwordInDB,ByteSource.Util.bytes(salt),getName());
        return a;

	}

}
