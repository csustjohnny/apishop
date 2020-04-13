package apishop.service.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import apishop.bean.Role;
import apishop.bean.User;
import apishop.mapper.RoleMapper;
import apishop.mapper.UserMapper;
import apishop.service.RoleService;
import apishop.service.UserService;

@Service
@CacheConfig(cacheNames="roles")
public class RoleServiceImp implements RoleService{
	@Autowired RoleMapper roleMapper;
	@Autowired UserService userService;
	@Autowired UserMapper userMapper;

	@Cacheable( key="'roles_'+#userName")
	public Set<String> listRoleNames(String userName) {
		// TODO Auto-generated method stub
		Set<String> result = new HashSet<String>();
        List<Role> roles = listRoles(userName);
        for (Role role : roles) {
            result.add(role.getRole());
        }
        return result;
	}

	@Cacheable( key="'roles_list_'+#userName")
	public List<Role> listRoles(String userName) {
		// TODO Auto-generated method stub
		List<Role> roles = new ArrayList<Role>();
        User user = userService.getByName(userName);
        if(null==user)
            return roles;
         
        roles = listRoles(user);
        return roles;
	}
	@Cacheable( key="'roles_u_'+#p0.id")
	public List<Role> listRoles(User user) {
		// TODO Auto-generated method stub
		    List<Role> roles = new ArrayList<Role>();
		    
            roles = roleMapper.getRolesByUid(user.getId());
		    
	        return roles;
	}

	@Cacheable( key="'roles_all'")
	public List<Role> list() {
		// TODO Auto-generated method stub
		return roleMapper.list();
	}

	@CacheEvict(allEntries=true)
	public void add(Role role) {
		// TODO Auto-generated method stub
		roleMapper.add(role);
	}

	@CacheEvict(allEntries=true)
	public void delete(int id) {
		// TODO Auto-generated method stub
		roleMapper.delete(id);
	}

	@Cacheable( key="'roles_'+#id")
	public Role get(int id) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleById(id);
	}

	@CacheEvict(allEntries=true)
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleMapper.update(role);
	}
	
	
	@CacheEvict(allEntries=true)
	@Transactional
	public void setUserRoles(int uid, int[] roleIds) {
		// TODO Auto-generated method stub
		//删除当前用户所有的角色
		 userMapper.deleteUserRoles(uid);
		 
		 //给用户添加角色
		 userMapper.addUserRoles(uid,roleIds);
		
	}

	
	
	

}
