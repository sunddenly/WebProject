package com.netctoss.controller.fee;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

@Controller
@RequestMapping("/fee")
public class FeeUpdateController {
	@Resource
	private CostMapperDao dao;
	
	@RequestMapping(value="/{id}/toEdit",method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public String toUpdate(
			@PathVariable(value="id")
			Integer id,
			Model model){
		Cost cost = dao.findById(id);
		model.addAttribute("cost", cost);
		return "fee/feemodi";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@Transactional
	public String update(Cost cost,HttpSession session){
		//获取更新记录，调用dao更新
		dao.updateCost(cost);
		//获取session中存储的page信息
		Page page = (Page)session.getAttribute("page");
		return "redirect:/fee/list/"+page.getPage();
	}
}
