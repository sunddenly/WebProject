package com.netctoss.controller.role;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netctoss.dao.RoleMapperDao;
import com.netctoss.entity.Page;
import com.netctoss.entity.Role;

@Controller
@RequestMapping("/role")
public class RoleListController {
	
	@Resource
	private RoleMapperDao dao;
	
	@RequestMapping(value="/list/{p}",method=RequestMethod.GET)
	public String execute(
			@PathVariable("p") int p,
			Model model){
		Page page = new Page(p, 5);
		List<Role> list = dao.findPage(page);
		//统计最大页数
		int totalRows = dao.findRows();
		int totalPage = 0;
		if(totalRows%page.getPageSize()==0){
			totalPage = totalRows/page.getPageSize();
		}else{
			totalPage = totalRows/page.getPageSize()+1;
		}
		page.setTotalPage(totalPage);
		model.addAttribute("roles", list);
		model.addAttribute("page", page);
		return "role/rolelist";
	}
	
	public RoleMapperDao getDao() {
		return dao;
	}
	public void setDao(RoleMapperDao dao) {
		this.dao = dao;
	}
	
}
