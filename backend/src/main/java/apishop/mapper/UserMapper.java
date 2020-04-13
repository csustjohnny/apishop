package apishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import apishop.bean.User;

public interface UserMapper {

	//通过用户名查询用户
	public User getByName(@Param("name")String name);

	//查询所有用户
	public List<User> listUser();

	//新增用户
	public void add(User user);

	//通过id删除用户
	public void deleteById(@Param("id")int id);

	//通过id获取用户
	public User getById(@Param("id")int id);

	//更新用户
	public void update(User user);

	//删除用户所具有的的角色
	public void deleteUserRoles(@Param("uid")int uid);

	//给用户配置角色
	public void addUserRoles(@Param("uid")int uid, @Param("rids")int[] roleIds);
}
