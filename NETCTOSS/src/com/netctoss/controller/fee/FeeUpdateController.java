package com.netctoss.controller.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;

@Controller
@RequestMapping("/fee")
public class FeeUpdateController {
	@Resource
	private CostMapperDao dao;
	
	@RequestMapping("/toUpdate")
	public String toUpdate(
			@RequestParam(value="id",required=false)
			Integer id,
			Model model){
		Cost cost = dao.findById(id);
		model.addAttribute("cost", cost);
		return "fee/feemodi";
	}
	
	@RequestMapping("/feeupdate.from")
	public String update(Cost cost){
		dao.updateCost(cost);
		return "redirect:/fee/feelist.from";
	}
}
