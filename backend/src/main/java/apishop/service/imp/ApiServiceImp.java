package apishop.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import apishop.bean.Api;
import apishop.bean.ApiParam;
import apishop.mapper.ApiMapper;
import apishop.service.ApiService;

@Service
@CacheConfig(cacheNames="api")
public class ApiServiceImp implements ApiService {

	@Autowired  ApiMapper apiMapper;
	
	@CacheEvict(allEntries=true)
	@Transactional
	public void addApi(Api api) {
		// TODO Auto-generated method stub
       //先把api的主体信息插入，返回的api的主键
		apiMapper.addApi(api);
		
		//设置每个参数的aid
		for(ApiParam ap :api.getParams()){
			ap.setAid(api.getId());
		}
		apiMapper.addApiParam(api.getParams());		
	}
 
	@CacheEvict(allEntries=true)
	@Transactional
	public void deleteApi(int id) {
		// TODO Auto-generated method stub
		//先删除api的所属的参数
		apiMapper.deleteParam(id);
        
		apiMapper.deleteApi(id);
	}

	@Cacheable(key="'api--'+ #a0.id +#a0.apiType + #a0.status + #a0.apiName + #a0.publisher + #a0.reviewer")
	public List<Api> getApi(Api api) {
		// TODO Auto-generated method stub
		
		List<Api> API = apiMapper.getApi(api);
		
		for(Api a : API){
			
			List<ApiParam> apiParams =  new ArrayList<ApiParam>();
			              
			               apiParams = apiMapper.getApiParams(a.getId());
			
				a.setParams(apiParams);
			
		}				
		return API;
	}

	@CacheEvict(allEntries=true)
	@Transactional
	public void updateApi(Api api) {
		// TODO Auto-generated method stub
       apiMapper.updateApi(api);
       //先删除所属的参数
       apiMapper.deleteParam(api.getId());
       
       apiMapper.addApiParam(api.getParams());	
	}
	@CacheEvict(allEntries=true)
	public void checkApi(int[] aids,String status, String userName) {
		// TODO Auto-generated method stub
	
		apiMapper.check(aids,status,userName);
	}

}
