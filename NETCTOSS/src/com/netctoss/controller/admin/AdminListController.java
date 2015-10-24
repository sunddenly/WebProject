package com.netctoss.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.vo.AdminInfoPage;

@Controller
@RequestMapping("/admin")
public class AdminListController {
	@Resource
	private AdminInfoMapperDao dao;
	@RequestMapping("/list/{moduleId}/{rolename}")
	public String execute(
			@PathVariable("moduleId") Integer moduleId,
			@PathVariable("rolename") String roleName,
			Model model){
		AdminInfoPage page = new AdminInfoPage();
		page.setModuleId(moduleId);
		page.setRoleName(roleName);
		List<AdminInfo> list = dao.findByCondition(page);
		System.out.println(list.size());
		model.addAttribute("admins",list);
		return "admin/adminlist";
	}
}
