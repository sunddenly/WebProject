package com.hebut.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hebut.dao.EmpDao;
import com.hebut.entity.Emp;

@Controller//添加组件扫描
public class EmpController {
	
	@Resource
	private EmpDao dao;
	
	public EmpDao getDao() {
		return dao;
	}

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/emplist")
	public String showList(Model model){
		//获取Emp记录
		List<Emp> list = dao.findAll();
		model.addAttribute("emps", list);
		return "emp_list";
	}
}
