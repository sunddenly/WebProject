package com.netctoss.controller.fee;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

@Controller
@RequestMapping("/fee")
@SessionAttributes("page")
public class FeeListController {
	@Resource
	private CostMapperDao dao;
	
	//对应/fee/feelist.from?page=1&pageSize=5请求
	@RequestMapping("/feelist")
	public String execute(
			Page page,
			Model model){//默认显示第1条，一页5条
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
