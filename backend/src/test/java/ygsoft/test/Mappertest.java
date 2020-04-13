package ygsoft.test;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import apishop.bean.Api;
import apishop.bean.User;
import apishop.service.ApiService;
import apishop.service.RoleService;
import apishop.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class Mappertest {


	@Autowired UserService user;
	@Autowired RoleService role;
	@Autowired ApiService apis;
	
    
	
	@Test
	public void test1() {
	  
		   Api api = new Api();
		       api.setId(1);
		       api.setApiType("测试");
		       api.setStatus("未审核");
		       
		   
          List<Api> list =   apis.getApi(api);
          
          System.out.println(role.list());
	}

		
	
}
