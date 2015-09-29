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
	
	//��Ӧ/fee/feelist.from?page=1&pageSize=5����
	@RequestMapping("/feelist")
	public String execute(
			Page page,
			Model model){//Ĭ����ʾ��1����һҳ5��
		List<Cost> list = dao.findPage(page);
		//�������ҳ��
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
