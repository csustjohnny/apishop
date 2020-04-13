package apishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import apishop.bean.Permission;
import apishop.service.PermissionService;

@Controller
@RequestMapping("/config")
public class PermissionController {

	@Autowired PermissionService permissionService;

/****列出所有权限*/	
	  @RequestMapping("/listPermission")
	  @ResponseBody
	  public List<Permission> list(){
	     
		 List<Permission> ps= permissionService.list();

	     return ps;
	    }

/****增加一条权限*/		  
	  @RequestMapping(value="/addPermission",method = RequestMethod.POST)
	  @ResponseBody
	  public String add(Permission permission){
	     
		  permissionService.add(permission);

	     return "success";
	    } 

/****删除一条权限***/		  
	  @RequestMapping(value="/deletePermission",method = RequestMethod.POST)
	  @ResponseBody
	  public String delete(@RequestParam("id") int id){
	     
		  permissionService.delete(id);

	     return "success";
	    } 
	  
/***修改一条权限***/		
	  @RequestMapping(value="/updatePermission",method = RequestMethod.POST)
	  @ResponseBody
	    public String update(Permission permission){
	 
	        permissionService.update(permission);
	        
	        return "success";
	    }

}
