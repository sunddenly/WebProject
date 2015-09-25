package com.netctoss.controller.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;

@Controller
@RequestMapping("/fee")
public class FeeAddController {
	@Resource
	private CostMapperDao dao;
	//对应/fee/toAdd.from
	@RequestMapping("toAdd")
	public String toAdd(){
		return "fee/feeadd";//进入fee/feeadd.jsp
	}
	
	@RequestMapping("/feeadd.from")
	public String add(Cost cost){
		System.out.println(cost);
		dao.addCost(cost);
		return "redirect:/fee/feelist.from";
	}
}
