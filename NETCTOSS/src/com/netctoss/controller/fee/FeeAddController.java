package com.netctoss.controller.fee;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

@Controller
@RequestMapping("/fee")
public class FeeAddController {
	@Resource
	private CostMapperDao dao;
	//��Ӧ/fee/toAdd.from
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(){
		return "fee/feeadd";//����fee/feeadd.jsp
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@Transactional
	public String add(Cost cost,HttpSession session){
		dao.addCost(cost);
		Page page = (Page)session.getAttribute("page");
		//�������ҳ��
		int totalRows = dao.findRows();
		int totalPage = 0;
		if(totalRows%page.getPageSize()==0){
			totalPage = totalRows/page.getPageSize();
		}else{
			totalPage = totalRows/page.getPageSize()+1;
		}		
		return "redirect:/fee/list/"+page.getTotalPage();
	}
}
