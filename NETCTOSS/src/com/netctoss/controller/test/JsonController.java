package com.netctoss.controller.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

@Controller
@RequestMapping("/test")
public class JsonController {
	@Resource
	private CostMapperDao dao;
	
	@RequestMapping("/test1")
	@ResponseBody
	public boolean f1(){
		return true;
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public Map<String,Object> f2(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 101);
		map.put("name", "JackSon");
		return map;
	}
	
	@RequestMapping("/test3")
	@ResponseBody
	public Cost f3(){
		Cost cost = dao.findById(1);
		return cost;
	}
	
	@RequestMapping("/test4")
	@ResponseBody
	public List f4(){
		Page page = new Page();
		List<Cost> list = dao.findPage(page);
		return list;
	}
	
	public CostMapperDao getDao() {
		return dao;
	}
	
	public void setDao(CostMapperDao dao) {
		this.dao = dao;
	}
}
