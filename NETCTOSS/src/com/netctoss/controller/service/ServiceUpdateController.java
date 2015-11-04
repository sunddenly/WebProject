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
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.dao.ServiceMapperDao;
import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;
import com.netctoss.entity.Cost;
import com.netctoss.entity.vo.ServiceLine;

@Controller
@RequestMapping("/service")
public class ServiceUpdateController {
	@Resource
	private ServiceMapperDao dao;//太长往请求头里放@RequestHeader
	@RequestMapping(value="/{id}/toEdit",method=RequestMethod.GET)
	public String toUpdate(
			@PathVariable("id") Integer id,
			Model model){
		ServiceLine service = dao.findServiceById(id);
		model.addAttribute("service", service);
		List<Cost> costs = dao.findCostName();
		model.addAttribute("costs",costs);
		return "service/servicemodi";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public boolean update(Integer cost_id,Integer service_id){
		if(service_id != null && cost_id != null){
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("cost_id", cost_id);
			map.put("service_id", service_id);
			dao.updateService(map);
			return true;
		}
		return false;
	}
}
