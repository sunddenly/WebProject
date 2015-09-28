package com.netctoss.controller.role;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netctoss.dao.RoleMapperDao;
import com.netctoss.entity.Role;

@Controller
@RequestMapping("/role")
public class RoleListController {
	
	@Resource
	private RoleMapperDao dao;
	
	@RequestMapping("/rolelist")
	public String execute(Model model){
		List<Role> list = dao.findAll();
		model.addAttribute("roles", list);
		return "role/rolelist";
	}
	
	public RoleMapperDao getDao() {
		return dao;
	}
	public void setDao(RoleMapperDao dao) {
		this.dao = dao;
	}
	
}
