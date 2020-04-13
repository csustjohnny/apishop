package apishop.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import apishop.bean.Api;
import apishop.bean.ApiParam;
import apishop.service.ApiService;

@Controller
@RequestMapping("/api")
public class ApiController {

	
	     @Autowired 
	     ApiService apiService;
	     
/*******api增加
 * @throws IOException 
 * @throws JsonMappingException 
 * @throws JsonParseException ***********/
	     @RequestMapping(value="/addApi",method = RequestMethod.POST)
	     @ResponseBody
	     public String addApi(Api api,@RequestParam("apiparams")String apiparams) {
	    
	    	 if(api.getApiName()!=null && api.getApiType()!=null 
	    		&& api.getApiAddress()!=null	 && api.getProtocol()!=null
	    		&& api.getRequestType()!=null && api.getReturnDataFormat()!=null
	    		&& api.getRequestDataFormat()!=null
	    	   ){
	    		 ObjectMapper mapper = new ObjectMapper();
	    		 
	    List<ApiParam> list;
		 try {
			list = mapper.readValue(apiparams, new TypeReference<List<ApiParam>>() {
						});
		 } catch (JsonParseException e) {
			// TODO Auto-generated catch block
			 return "error";
		 } catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			 return "error";
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			 return "error";
		}
	    		 
	    		 Subject subject = SecurityUtils.getSubject();
	    		 if( subject.getPrincipal()!=null){
	    			 String userName = subject.getPrincipal().toString();
		    		 api.setPublisher(userName);
	    		 }
	    		
	    		 api.setStatus("未审核");
	    		 api.setTime(new Date());
	    		 api.setParams(list);//把参数设置进去
	    		 apiService.addApi(api);
	    		 return "success";
	    	   }
	    	 	    	 
	    	 return "error";
	     }
	     
/*******api修改
 * @throws IOException 
 * @throws JsonMappingException 
 * @throws JsonParseException ***********/
	     @RequestMapping(value="/updateApi",method = RequestMethod.POST)
	     @ResponseBody
	     public String updateApi(Api api,@RequestParam("apiparams")String apiparams){
	    	 
	    	 if(api.getId()!=0 && api.getApiName()!=null && api.getApiType()!=null 
	 	    		&& api.getApiAddress()!=null	 && api.getProtocol()!=null
		    		&& api.getRequestType()!=null && api.getReturnDataFormat()!=null
		    		&& api.getRequestDataFormat()!=null){
	    		 
	    		 ObjectMapper mapper = new ObjectMapper();
	    		 List<ApiParam> list;
				try {
					list = mapper.readValue(apiparams, new TypeReference<List<ApiParam>>(){
						});
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					return "error";
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					return "error";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					return "error";
				}
	    		 
	    		 Subject subject = SecurityUtils.getSubject();
	    		 if( subject.getPrincipal()!=null){
	    			 String userName = subject.getPrincipal().toString();
	    			 api.setPublisher(userName);
	    		 }
	    		 
	    		 api.setStatus("未审核");
	    		 api.setParams(list);//把参数设置进去
	    		 apiService.updateApi(api);	    		 
	    		 return "success";
	    	   }
	    	 	    	 
	    	 return "error";
	     }	

/*******api审核***********/
	     @RequestMapping(value="/checkApi",method = RequestMethod.POST)
	     @ResponseBody
	     public String checkApi(@RequestParam("aids[]") int[] aids,
	    		                @RequestParam("status")String status ){
	    	 
	    	 if(aids.length!=0 ){
	    		 Subject subject = SecurityUtils.getSubject();
	    		 String userName = null;
	    		 if( subject.getPrincipal()!=null){
	    			 userName = subject.getPrincipal().toString();

	    		 }
	    		 apiService.checkApi(aids,status,userName);
	    		 
	    		 return "success";
	    	   }
	    	 	    	 
	    	 return "error";
	     }	
	     
/*******api删除***********/
	     @RequestMapping(value="/deleteApi",method = RequestMethod.POST)
	     @ResponseBody
	     public String deleteApi(@RequestParam("id")int id){
	    	 
	    	 if(id !=0 ){
	    		 apiService.deleteApi(id);
	    		 
	    		 return "success";
	    	   }
	    	 	    	 
	    	 return "error";
	     }
	     
/*******api查询***********/
	     @RequestMapping(value="/getApi",method = RequestMethod.POST)
	     @ResponseBody
	     public List<Api> getApi(Api api){

	    	 if(api.getId()==0 && api.getApiName()==null 
	    	 && api.getApiType()==null && api.getStatus()==null
	    	 && api.getPublisher()==null && api.getReviewer()==null
	    			 )
	    		 return null;
	    	     
	    	 return apiService.getApi(api);
	     }	     
}
