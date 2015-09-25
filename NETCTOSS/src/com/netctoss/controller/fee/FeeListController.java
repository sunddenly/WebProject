package com.netctoss.controller.fee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;

@Controller
@RequestMapping("/fee")
public class FeeListController {
	@Resource
	private CostMapperDao dao;
	//∂‘”¶/fee/feelist.from«Î«Û
	@RequestMapping("/feelist")
	public String execute(Model model){
		List<Cost> list = dao.findAll();
		model.addAttribute("costs",list);
		return "fee/feelist";
	}
}
