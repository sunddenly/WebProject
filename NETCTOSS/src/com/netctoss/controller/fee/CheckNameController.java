package com.netctoss.controller.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;

@Controller
@RequestMapping("/fee")
public class CheckNameController {
	@Resource
	private CostMapperDao dao;
	
	@RequestMapping("/checkName")
	@ResponseBody
	public boolean check(@RequestParam(value="name",required=false) String name){
		
		Cost cost = dao.findByName(name);
		if(cost == null){
			return true;//没有记录 表明资费名可用
		}else{
			return false;//有记录，表明不可用
		}
	}
}
