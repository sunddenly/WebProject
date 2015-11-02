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
	@RequestMapping(value="/list/{os_username}/{unix_host}/{idcard_no}/{status}/{p}",method=RequestMethod.GET)
	public String execute(
		@PathVariable("os_username") String os_username,
		@PathVariable("unix_host") String unix_host,
		@PathVariable("idcard_no") String idcard_no,
		@PathVariable("status")	String status,
		@PathVariable("p") Integer p,
		Model model){
		//获取查询条件
		ServicePage page = new ServicePage();
		page.setOs_username(os_username);
		page.setUnix_host(unix_host);
		page.setIdcard_no(idcard_no);
		page.setStatus(status);
		page.setPage(p);
		//进行条件查询
		List<ServiceLine> list = dao.findByCondition(page);
		//获取记录行数
		Integer rowNum = dao.findRows();
		//计算页数
		Integer pageSize = page.getPageSize();
		Integer pageNum =0;
		if(rowNum%pageSize==0){
			pageNum = rowNum/pageSize;
		}else{
			pageNum = rowNum/pageSize+1;
		}
		page.setTotalPage(pageNum);
		model.addAttribute("services",list);
		model.addAttribute("totalPage",pageNum);
		//将条件*清空
		page.setOs_username(convert(page.getOs_username()));
		page.setUnix_host(convert(page.getUnix_host()));
		page.setIdcard_no(convert(page.getIdcard_no()));
		model.addAttribute("page", page);
		return "service/servicelist";
	}
	public String convert(String s){
		if("*".equals(s)){
			return "";
		}else{
			return s;
		}
	}
}
