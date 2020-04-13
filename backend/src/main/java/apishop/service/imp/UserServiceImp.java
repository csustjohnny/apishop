package apishop.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import apishop.bean.User;
import apishop.mapper.UserMapper;
import apishop.service.UserService;

@Service
@CacheConfig(cacheNames="user")
public class UserServiceImp implements UserService {

	@Autowired UserMapper userMapper;
	
	@Cacheable( key="'user_pass_'+#name")
	public String getPassword(String name) {
		// TODO Auto-generated method stub
		 User user = userMapper.getByName(name);
	     
		 if(null==user)return null;
	     
		 return user.getPassword();
	}
   @Cacheable( key="'user_'+#name") 
	public User getByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.getByName(name);
	}

	@Cacheable(key="'user_all'")
	public List<User> list() {
		// TODO Auto-generated method stub
		return userMapper.listUser();
	}

	@CacheEvict(allEntries=true)
	public void add(User user) {
		// TODO Auto-generated method stub
		userMapper.add(user);
	}

	@CacheEvict(allEntries=true)
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteById(id);
        
		//删除该用户的角色
	}
	@Cacheable( key="'user_'+#id")
	public User get(int id) {
		// TODO Auto-generated method stub
		return userMapper.getById(id);
	}

	@CacheEvict(allEntries=true)
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}
	
	
	

}
