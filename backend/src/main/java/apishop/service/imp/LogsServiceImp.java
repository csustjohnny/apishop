package apishop.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apishop.bean.Logs;
import apishop.mapper.LogsMapper;
import apishop.service.LogsService;

@Service
public class LogsServiceImp implements LogsService {

	
	@Autowired LogsMapper logsMapper;
	
	public void saveLogs(String userName, String action) {
		// TODO Auto-generated method stub
		logsMapper.saveLogs(userName, action);
	}

	public List<Logs> listLogs() {
		// TODO Auto-generated method stub
		return logsMapper.listLogs();
	}

}
