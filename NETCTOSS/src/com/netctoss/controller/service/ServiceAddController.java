package com.netctoss.controller.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netctoss.dao.ServiceMapperDao;
import com.netctoss.entity.Cost;

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
	public String Add(){
		return "redirect:/account/list/*/*/*/-1/1";
	}
}
