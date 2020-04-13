package apishop.service;

import java.util.List;
import java.util.Set;

import apishop.bean.Permission;
import apishop.bean.Role;

public interface PermissionService {
	
    //通过用户名获取所拥有的权限
	public Set<String> listPermissions(String userName);
	 
	//查询所有权限
    public List<Permission> list();
    
    //增加一个权限
    public void add(Permission permission);
    
    //删除一个权限
    public void delete(int id);
    
    //获取一个权限
    public Permission get(int id);
    
    //修改一个权限
    public void update(Permission permission);
 
    //给角色设置权限
	 public void setPermissions(int role, int[] permissionIds);
	 
	 //删除某个角色拥有的权限
	 public void deleteRolePermissions(int roleId);
	 
	 //删除某个角色拥有的一项权限
	 public void deleteRoleOnePermission(int roleId,int permissionId);
	 
    //查看角色所有的权限
    public List<Permission> listRolePermissions(Role role);

    //需要拦截的URL路径
	public boolean needInterceptor(String requestURI);

	//通过url查询所描述的动作
	public String getActionByUrl(String requestURI);

	
}
