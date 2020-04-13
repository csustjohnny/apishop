package apishop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import apishop.bean.Permission;
import apishop.bean.Role;
import apishop.service.PermissionService;
import apishop.service.RoleService;

@Controller
@RequestMapping("/config")
public class RoleController {

	 @Autowired RoleService roleService;
	 @Autowired PermissionService permissionService;

/****列出所有角色以及他们拥有的权限*****/	 
	@RequestMapping("/listRole")
	@ResponseBody
    public Map<Role,List<Permission>> listRole(){
        
		List<Role> rs= roleService.list();
         
        Map<Role,List<Permission>> role_permissions = new HashMap<Role, List<Permission>>();
         
        for (Role role : rs) {
            List<Permission> ps = permissionService.listRolePermissions(role);
            role_permissions.put(role, ps);
        }

        return role_permissions;
    }

/****新增角色*****/
	@RequestMapping(value="/addRole",method = RequestMethod.POST)
	@ResponseBody
    public String list(Role role){
		
		if (role.getRole()==null) {
			return "角色名称不能为空";
		}

        roleService.add(role);
        
        return "success";
    }

/****删除角色*****/
	@RequestMapping(value="/deleteRole",method = RequestMethod.POST)
	@ResponseBody
    public String delete(@RequestParam("rid")int rid){
        roleService.delete(rid);
       
        return "success";
    } 

/****更新角色（以及更新角色所拥有的权限）*****/
	 @RequestMapping(value="/updateRole",method = RequestMethod.POST)
	 @ResponseBody
	 public String update(Role role,@RequestParam(value="pids[]")int[] permissionIds){
		   
		    if(role.getId()!=0){
		    	permissionService.setPermissions(role.getId(), permissionIds);
		        roleService.update(role);
		        return "success";
		    }
		   
	        return "error";
	    }
	 
	 
/*******删除角色所拥有的所有的权限***************/
	 @RequestMapping(value="/deleteRolePermissions",method = RequestMethod.POST)
	 @ResponseBody
	 public String deleteRolePermissons(@RequestParam("rid")int rid){
		 
		 permissionService.deleteRolePermissions(rid);
		 
		 return "success";
	 }
	 
/*******删除角色所拥有的所有的某一条权限***************/
	 @RequestMapping(value="/deleteRoleOnePermissions",method = RequestMethod.POST)
	 @ResponseBody
	 public String deleteRoleOnePermissons(
			 @RequestParam("rid")int rid,@RequestParam("pid")int pid){
		 
		   if (rid==0 || pid==0) return "参数出错";
	        	 
		   permissionService.deleteRoleOnePermission(rid, pid);
		 
		    return "success";
	 }
}
