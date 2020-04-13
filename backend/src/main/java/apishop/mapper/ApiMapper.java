package apishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import apishop.bean.Api;
import apishop.bean.ApiParam;

public interface ApiMapper {

	   //增加
		public void addApi(Api api);
		
		//删除
		public void deleteApi(@Param("id")int id);
		
		//查询(id,apiName,apiType,status,publisher，reviewer)
		public List<Api> getApi(Api api);
		
		//修改(审核)
		public void updateApi(Api api);
		
		//api参数的增加
		public void addApiParam(@Param("apiParams")List<ApiParam> apiParams);
		
		//删除api的参数
		public void deleteParam(@Param("aid")int aid);

		//通过api的id获取参数
		public List<ApiParam> getApiParams(@Param("aid")int aid);

		//审核api
		public void check(@Param("aids")int[] aids, @Param("status")String status,@Param("userName")String userName);
}
