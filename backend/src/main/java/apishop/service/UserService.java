package apishop.service;

import java.util.List;

import apishop.bean.User;

public interface UserService {

	//通过用户名获取密码
	public String getPassword(String name);
    
	//通过用户名获取用户对象
	public User getByName(String name);
     
	//查看所有用户
    public List<User> list();
    
    //新增用户
    public void add(User user);
    
    //删除用户
    public void delete(int id);
    
    //通过id查询用户
    public User get(int id);
    
    //修改用户
    public void update(User user);
    

}
