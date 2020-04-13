package apishop.service.imp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import apishop.bean.Permission;
import apishop.bean.Role;
import apishop.mapper.PermissionMapper;
import apishop.mapper.RoleMapper;
import apishop.service.PermissionService;

@Service
@CacheConfig(cacheNames="Permission")
public class PermissoinServiceImp implements PermissionService{

	@Autowired PermissionMapper permissionMapper;
	
	@Autowired RoleMapper roleMapper;
	
	@Cacheable( key="'Permission_'+#userName")
	public Set<String> listPermissions(String userName) {
		// TODO Auto-generated method stub
		return permissionMapper.listPermissions(userName);
	}

	@Cacheable( key="'Permission_all'")
	public List<Permission> list() {
		// TODO Auto-generated method stub
		return permissionMapper.list();
	}

	@CacheEvict(allEntries=true)
	public void add(Permission permission) {
		// TODO Auto-generated method stub
		permissionMapper.add(permission);
	}

	@CacheEvict(allEntries=true)
	public void delete(int id) {
		// TODO Auto-generated method stub
		permissionMapper.deleteById(id);
	}

	@Cacheable( key="'Permission_'+#id")
	public Permission get(int id) {
		// TODO Auto-generated method stub
		return permissionMapper.getById(id);
	}

	@CacheEvict(allEntries=true)
	public void update(Permission permission) {
		// TODO Auto-generated method stub
		permissionMapper.update(permission);
	}

	@Cacheable( key="'Permission_'+#requestURI")
	public boolean needInterceptor(String requestURI) {
		// TODO Auto-generated method stub
		return permissionMapper.needInterceptor(requestURI);
	}

	@Cacheable( key="'Permission_'+#p0.role")
	public List<Permission> listRolePermissions(Role role) {
		// TODO Auto-generated method stub
		return permissionMapper.listRolePermissions(role);
	}

	@Cacheable( key="'Permission_s_'+#requtURI")
	public String getActionByUrl(String requestURI) {
		// TODO Auto-generated method stub
		return permissionMapper.getActionByUrl(requestURI);
	}

	//给角色配置权限
			@Transactional
			@CacheEvict(allEntries=true)
			public void setPermissions(int roleId, int[] permissionIds) {
				// TODO Auto-generated method stub
				
				//删除角色所拥有的权限（引用的下面的这个函数）
				  deleteRolePermissions(roleId);
				
				//给角色配置权限
				roleMapper.setRolePermissions(roleId,permissionIds);
			}

			//删除角色所拥有的权限
			@CacheEvict(allEntries=true)
			public void deleteRolePermissions(int roleId) {
				// TODO Auto-generated method stub
				 roleMapper.deleteRolePermissions(roleId);
			}

			//删除角色拥有的某一项权限
			@CacheEvict(allEntries=true)
			public void deleteRoleOnePermission(int roleId, int permissionId) {
				// TODO Auto-generated method stub
				 roleMapper.deleteRoleOnePermission(roleId,permissionId);
			}


}
