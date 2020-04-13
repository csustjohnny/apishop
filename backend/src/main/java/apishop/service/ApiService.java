package apishop.service;

import java.util.List;

import apishop.bean.Api;


public interface ApiService {

	//增加
	public void addApi(Api api);
	
	//删除
	public void deleteApi(int id);
	
	//查询(id,apiName,apiType,status)
	public List<Api> getApi(Api api);
	
	//修改
	public void updateApi(Api api);

	//审核api
	public void checkApi(int[] aids, String status,String userName );
}
