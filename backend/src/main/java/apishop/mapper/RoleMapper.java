package apishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import apishop.bean.Role;

public interface RoleMapper {

	//通过用户id获取所拥有的角色
	public List<Role> getRolesByUid(@Param("id")int id);

	//查询所有的角色
	public List<Role> list();

	//新增角色
	public void add(Role role);

	//通过id删除角色
	public void delete(@Param("id")int id);

	//通过id获取一个角色
	public Role getRoleById(@Param("id")int id);

	//更新一个角色
	public void update(Role role);

	//删除角色所拥有的权限
	public void deleteRolePermissions(@Param("rid")int roleId);

	//给角色配置权限
	public void setRolePermissions(@Param("rid")int roleId,@Param("pids") int[] permissionIds);

	//删除角色拥有的某一项权限
	public void deleteRoleOnePermission(@Param("rid")int roleId, @Param("pid")int permissionId);

}
