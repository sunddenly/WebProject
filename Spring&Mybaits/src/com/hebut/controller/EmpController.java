package com.hebut.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hebut.dao.EmpMapperDao;
import com.hebut.entity.Emp;

@Controller
public class EmpController {
	@Resource
	private EmpMapperDao dao;//Mapper”≥…‰∆˜
	
	@RequestMapping("/emplist")
	public String showList(Model model){
		List<Emp> list = dao.findAll();
		model.addAttribute("emps", list);
		return "emplist";//Ω¯»Îemp_list.jsp
	}
	@RequestMapping("/delete")
	public String Delete(@RequestParam("id") int id){
		System.out.println(id);
		return null;
	}
}
