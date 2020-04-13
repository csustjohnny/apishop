package apishop.service;

import java.util.List;
import java.util.Set;

import apishop.bean.Role;
import apishop.bean.User;

public interface RoleService {

	public Set<String> listRoleNames(String userName);
    
	public List<Role> listRoles(String userName);
    
	public List<Role> listRoles(User user);
 
    public List<Role> list();
    
    public void add(Role role);
    
    public void delete(int id);
    
    public Role get(int id);
    
    public void update(Role role);
    	 
	    //给用户设置(更新)角色
	 public void setUserRoles(int uid, int[] roleIds);
}
