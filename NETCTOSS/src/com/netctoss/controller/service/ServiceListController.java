package com.netctoss.controller.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netctoss.dao.ServiceMapperDao;
import com.netctoss.entity.vo.ServiceLine;
import com.netctoss.entity.vo.ServicePage;

@Controller
@RequestMapping("/service")
public class ServiceListController {
	@Resource
	private ServiceMapperDao dao;
	@RequestMapping(value="/list/{os_username}/{unix_host}/{idcard_no}/{status}",method=RequestMethod.GET)
	public String execute(
		@PathVariable("os_username") String os_username,
		@PathVariable("unix_host") String unix_host,
		@PathVariable("idcard_no") String idcard_no,
		@PathVariable("status")	String status,
		Model model){
		ServicePage page = new ServicePage();
		page.setOs_username(os_username);
		page.setUnix_host(unix_host);
		page.setIdcard_no(idcard_no);
		page.setStatus(status);
		List<ServiceLine> list = dao.findByCondition(page);
		model.addAttribute("services",list);
		return "service/servicelist";
	}
}
