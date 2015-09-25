package com.netctoss.controller.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;

@Controller
@RequestMapping("/fee")
public class FeeDeleteController {
	@Resource
	private CostMapperDao dao;
	@RequestMapping("/feedelete")
	public String execute(@RequestParam(value="id",required=false) int id){
		dao.deleteCost(id);
		return "redirect:/fee/feelist.from";
	}
}
