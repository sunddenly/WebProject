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
@SessionAttributes("page")
@Transactional(readOnly=true)
public class FeeListController {
	@Resource
	private CostMapperDao dao;
	
	//对应/fee/feelist.from?page=1&pageSize=5请求
	//对应/fee/list/1请求
	@RequestMapping(value="/list/{p}",method=RequestMethod.GET)
	public String execute(
			@PathVariable("p") int p,
			Model model){//默认显示第1条，一页5条
		Page page = new Page(p, 5);
		List<Cost> list = dao.findPage(page);
		//计算最大页数
		int totalRows = dao.findRows();
		int totalPage = 0;
		if(totalRows%page.getPageSize()==0){
			totalPage = totalRows/page.getPageSize();
		}else{
			totalPage = totalRows/page.getPageSize()+1;
		}
		page.setTotalPage(totalPage);
		model.addAttribute("costs",list);
		model.addAttribute("page", page);
		return "fee/feelist";
	}
}
