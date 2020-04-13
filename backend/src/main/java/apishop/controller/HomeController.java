package apishop.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import apishop.service.RoleService;

@Controller
@RequestMapping("")
public class HomeController {

	
	  @Autowired
	  RoleService roleService;
	
	@RequestMapping({"/","index"})
	public String home(){
		
		return "index";
	}
	@RequestMapping("/logIn")
	public String login() {
		return "logIn";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	@RequestMapping("/allUsers")
	public String allUsers() {
		return "allUsers";
	}
	@RequestMapping("/api")
	public String api() {
		return "api";
	}
	@RequestMapping("/apiadd")
	public String apiadd() {
		return "apiadd";
	}
	@RequestMapping("/assessorIndex")
	public String assessorIndex() {
		return "assessorIndex";
	}
	@RequestMapping("/authority")
	public String authority() {
		return "authority";
	}
	@RequestMapping("/backstageIndex")
	public String backstageIndex() {
		return "backstageIndex";
	}
	@RequestMapping("/commonUser")
	public String commonUser() {
		return "commonUser";
	}
	@RequestMapping("/logs")
	public String logs() {
		return "logs";
	}
	@RequestMapping("/personal")
	public String personal() {
		return "personal";
	}
	@RequestMapping("/resources")
	public String resources() {
		return "resources";
	}
	@RequestMapping("/roles")
	public String roles() {
		return "roles";
	}
	@RequestMapping("/superManager")
	public String superManager() {
		return "superManager";
	}
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	//没有权限跳转界面
	@RequestMapping("/unauthorized")
	public String unauthorized(){
		
		return "unauthorized";
	}
	
	/******登录****************/
    @RequestMapping(value = "/login", method = RequestMethod.POST) // 登录功能  
    @ResponseBody
	public Map<String, Object> login(@RequestParam(value = "username") String name,
			            @RequestParam(value = "password") String password) {
				
         Subject subject = SecurityUtils.getSubject();
         UsernamePasswordToken token = new UsernamePasswordToken(name, password);
         Map<String, Object> map = new HashMap<String, Object>();
         String mess;
         String sid;
         try{
        	 subject.login(token);
        	 
        	 sid = (String) subject.getSession().getId();
        	 
         }catch(AuthenticationException e){
        	 mess = "登录失败，用户名或密码错误";
        	 map.put("status", mess);
        	 return  map;
          }
           Set<String> roles = roleService.listRoleNames(name);
           mess = "success";
           map.put("role", roles);
           map.put("sid", sid);
    	   return map;
	}

}
