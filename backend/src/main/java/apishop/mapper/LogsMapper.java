package apishop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import apishop.bean.Logs;

public interface LogsMapper {

	    //保存日志
		public void saveLogs(@Param("userName")String userName,@Param("action")String action);
		
		//查看工作日志
		public List<Logs> listLogs();
}
