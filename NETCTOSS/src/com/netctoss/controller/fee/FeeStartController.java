package com.netctoss.controller.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netctoss.dao.CostMapperDao;

@Controller
@RequestMapping("/fee")
public class FeeStartController {
	@Resource
	private CostMapperDao dao;
	@RequestMapping("/feestart")
	public String startFee(
			@RequestParam(value="id",required=false) int id){
		dao.startFee(id);
		return "redirect:/fee/feelist.from";
	}
}
