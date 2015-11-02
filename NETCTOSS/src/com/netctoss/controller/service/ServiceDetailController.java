package com.netctoss.controller.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.dao.ServiceMapperDao;
import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;
import com.netctoss.entity.vo.ServiceLine;

@Controller
@RequestMapping("/service")
public class ServiceDetailController {
	@Resource
	private ServiceMapperDao dao;//太长往请求头里放@RequestHeader
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String execute(
			@PathVariable("id") Integer id,
			Model model){
		ServiceLine service = dao.findServiceById(id);
		model.addAttribute("s",service);
		return "service/servicedetail";
	}
}
