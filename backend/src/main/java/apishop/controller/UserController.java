package apishop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import apishop.bean.Role;
import apishop.bean.User;
import apishop.service.RoleService;
import apishop.service.UserService;

@Controller
@RequestMapping("/config")
public class UserController {

	 @Autowired UserService userService;
	 @Autowired RoleService roleService;



/**列出用户及他们所具有的角色**/	
	   @RequestMapping("/listUser")
	   @ResponseBody
	    public Map<User,List<Role>> list(){
	        
		   List<User> us= userService.list();

	        Map<User,List<Role>> user_roles = new HashMap<User, List<Role>>();
	        
	        for (User user : us) {
	            List<Role> roles=roleService.listRoles(user);
	            user_roles.put(user, roles);
	        }
	 
	        return user_roles;
	    }

/**通过用户名查询用户**/
	   @RequestMapping("/getUser")
	   @ResponseBody
	   public User get(@RequestParam("userName")String userName){
		   return userService.getByName(userName);
	   }
	   
/***新增用户（注册用户）*/	 
	    @RequestMapping(value="/addUser",method = RequestMethod.POST)
	    @ResponseBody
	    public String add(@RequestParam("userName")String name, 
	    		          @RequestParam("password")String password){
	    	
	        if(name.trim().length()==0 || password.trim().length()==0 )
	        	return "账号或密码不符合规范";
	      
	        if(userService.getByName(name.trim())!=null)return "该用户已存在";
	        
	        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
	        int times = 2;
	        String algorithmName = "md5";
	          
	        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
	         
	        User u = new User();
	        
	        u.setUserName(name);
	        u.setPassword(encodedPassword);
	        u.setSalt(salt);
	        userService.add(u);
	         
	        return "success";
	    }

 /**删除用户*/	 	    
	    @RequestMapping(value="/deleteUser",method = RequestMethod.POST)
	    @ResponseBody
        public String delete( @RequestParam("id")int id){
                userService.delete(id);
                return "success";
	    }

/**修改用户密码*/	 
	    @RequestMapping(value="/updateUserPaswword",method = RequestMethod.POST)
	    @ResponseBody
	     public String updatePassword(User user,
	    		                @RequestParam("oldPassword")String oldPassword){
	        	        
	        if(user.getPassword().trim().length()!=0  && 
	           user.getPassword().trim().equals(oldPassword.trim())) {
	            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
	            int times = 2;
	            String algorithmName = "md5";
	            String encodedPassword = new SimpleHash(algorithmName,user.getPassword(),salt,times).toString(); 
	            user.setSalt(salt);
	            user.setPassword(encodedPassword);
	            
	            userService.update(user);
	            return "success";
	        }
	        else
	           return "error";
	 
	    }
	    
/******给用户配置角色（更新）****************/
	    @RequestMapping(value="/addUserRole",method = RequestMethod.POST)
	    @ResponseBody
	    public String addUserRole( @RequestParam("uid")int uid, @RequestParam("rids[]")int[] rids){
	    	
	    	roleService.setUserRoles(uid, rids);
	    	
	    	return "success";
	    }



}
