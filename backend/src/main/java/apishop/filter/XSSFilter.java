package apishop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class XSSFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
    	
    }
 
   
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        
    	HttpServletRequest request = (HttpServletRequest)req;
    	
    	
        
        request = new XssHttpServletRequestWrapper(request);
       
        chain.doFilter(request, res);
    }
 
    
    public void destroy() {
    	
    }


}
