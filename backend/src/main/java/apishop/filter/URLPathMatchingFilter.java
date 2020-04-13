package apishop.filter;

import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import apishop.service.LogsService;
import apishop.service.PermissionService;

public class URLPathMatchingFilter  extends PathMatchingFilter{
	@Autowired
	  PermissionService permissionService;
	
	@Autowired  LogsService logs;

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		String requestURI = getPathWithinApplication(request);

		System.out.println("requestURI:" + requestURI);
		
		String action = permissionService.getActionByUrl(requestURI);
		
		Subject subject = SecurityUtils.getSubject();
		// 如果没有登录，就跳转到登录页面
	  if (!subject.isAuthenticated()) {
	//	    System.out.println("未登录");
		    if( action!=null)
		    logs.saveLogs("未登录用户", action);
			WebUtils.issueRedirect(request, response, "/index");
			return false;
		}

		// 看看这个路径权限里有没有维护，如果没有维护，一律放行
		boolean needInterceptor = permissionService.needInterceptor(requestURI);
		    
		if (!needInterceptor) {
			return true;
		} else {
			boolean hasPermission = false;
			String userName = subject.getPrincipal().toString();
			Set<String> permissionUrls = permissionService.listPermissions(userName);
			
			for (String url : permissionUrls) {
				// 表示当前用户有这个权限
				if (url.equals(requestURI)) {
					hasPermission = true;
					break;
				}
			}
//            System.out.println("aaaa");
			if (hasPermission){
				if( action!=null)
				    logs.saveLogs(userName, action);
				return true;
			} 
							
			else{
				
				WebUtils.issueRedirect(request, response, "/unauthorized");
				
				return false;
			}

		}

	}
}

