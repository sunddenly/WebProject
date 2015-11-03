package com.netctoss.controller.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.ServiceMapperDao;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Service;

@Controller
@RequestMapping("/service")
public class ServiceAddController {
	@Resource
	private ServiceMapperDao dao;//太长往请求头里放@RequestHeader
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(Model model){
		List<Cost> costs = dao.findCostName();
		model.addAttribute("costs",costs);
		return "service/serviceadd";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public boolean Add(Service service){
		String unixHost = service.getUnix_host();
		String osUsername = service.getOs_username();
		String account_id = service.getAccount_id()+"";
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("unixHost",unixHost);
		map.put("osUsername", osUsername);
		String accountId = dao.validateOsusername(map);
		if(accountId==null){
			dao.addService(service);
			return true;
		}
		return false;
	}
}
