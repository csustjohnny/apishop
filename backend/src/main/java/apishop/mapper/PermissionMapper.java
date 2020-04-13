package apishop.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import apishop.bean.Permission;
import apishop.bean.Role;

public interface PermissionMapper {

	//通过用户名查询用户所拥有的权限
	public Set<String> listPermissions(@Param("userName")String userName);

	//查询所有权限
	public List<Permission> list();

	//新增一条权限
	public void add(Permission permission);

	//删除一条权限
	public void deleteById(@Param("id")int id);

	//查询一条权限
	public Permission getById(@Param("id")int id);

	//权限更新
	public void update(Permission permission);

	//判断该路径是否需要拦截
	public boolean needInterceptor(@Param("requestURI")String requestURI);

	//通过角色查询角色所拥有的权限
	public List<Permission> listRolePermissions(Role role);

	//通过url查询所描述的动作
	public String getActionByUrl(@Param("requestURI")String requestURI);

}
