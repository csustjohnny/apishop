package apishop.service;

import java.util.List;

import apishop.bean.Logs;

public interface LogsService {

	//保存工作日志
	public void saveLogs(String userName,String action);
	
	//查看工作日志
	public List<Logs> listLogs();
	
}
