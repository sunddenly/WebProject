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
	//��Ӧ/fee/toAdd.from
	@RequestMapping("toAdd")
	public String toAdd(){
		return "fee/feeadd";//����fee/feeadd.jsp
	}
	
	@RequestMapping("/feeadd.from")
	public String add(Cost cost){
		dao.addCost(cost);
		return "redirect:/fee/feelist.from";
	}
}
