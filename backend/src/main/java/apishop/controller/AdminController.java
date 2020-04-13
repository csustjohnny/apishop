package apishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import apishop.bean.Logs;
import apishop.service.LogsService;

@RequestMapping("/admin")
@Controller
public class AdminController  {

	@Autowired LogsService logsService;
	
	
	//查看工作日志
	@RequestMapping(value="/listLogs",method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Logs> listLogs(@RequestParam("pageNum")int pageNum,
			                       @RequestParam("pageSize")int pageSize){
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<Logs> list = logsService.listLogs();
		
		PageInfo<Logs> page = new PageInfo<Logs>(list, 5);
		
		return page;
	}
}
