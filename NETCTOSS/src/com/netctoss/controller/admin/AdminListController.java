package com.netctoss.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Privilege;
import com.netctoss.entity.vo.AdminInfoPage;
import com.netctoss.util.PrivilegeReader;

@Controller
@RequestMapping("/admin")
public class AdminListController {
	@Resource
	private AdminInfoMapperDao dao;
	@RequestMapping("/list/{moduleId}/{rolename}/{p}")
	public String execute(
			@PathVariable("moduleId") Integer moduleId,
			@PathVariable("rolename") String roleName,
			@PathVariable("p") Integer p,
			Model model){
		//��ȡprivilege.xml�е�Ȩ����Ϣ
		List<Privilege> pris = PrivilegeReader.getPrivileges();
		model.addAttribute("pris", pris);
		//��ϲ�ѯ
		AdminInfoPage page = new AdminInfoPage();
		page.setModuleId(moduleId);
		page.setRoleName(roleName);
		page.setPage(p);
		List<AdminInfo> list = dao.findByCondition(page);
		model.addAttribute("admins",list);
		//ͳ����ҳ��
		int totalRows = dao.findRows(page);
		int totalPage = 0;
		if(totalRows%page.getPageSize()==0){
			totalPage = totalRows/page.getPageSize();
		}else{
			totalPage = totalRows/page.getPageSize()+1;
		}
		page.setTotalPage(totalPage);	
		//������*���
		page.setRoleName(convert(page.getRoleName()));
		model.addAttribute("page",page);
		return "admin/adminlist";
	}
	public String convert(String s){
		if("*".equals(s)){
			return "";
		}else{
			return s;
		}
	}
}
