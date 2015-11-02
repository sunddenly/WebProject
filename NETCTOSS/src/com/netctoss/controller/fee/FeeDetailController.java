package com.netctoss.controller.fee;

import java.util.List;

import javax.annotation.Resource;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

@Controller
@RequestMapping("/fee")
@Transactional(readOnly=true)
public class FeeDetailController {
	@Resource
	private CostMapperDao dao;
	
	//对应/fee/feelist.from?page=1&pageSize=5请求
	//对应/fee/list/1请求
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String execute(
			@PathVariable("id") int id,
			Model model){//默认显示第1条，一页5条
		Cost cost = dao.findById(id);
		model.addAttribute("cost",cost);
		return "fee/feedetail";
	}
}
