package com.netctoss.controller.role;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netctoss.dao.RoleMapperDao;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;
import com.netctoss.entity.Privilege;
import com.netctoss.entity.Role;
import com.netctoss.entity.RoleModule;
import com.netctoss.util.PrivilegeReader;

@Controller
@RequestMapping("/role")
public class RoleAddController {
	@Resource
	private RoleMapperDao dao;
	//��Ӧ/fee/toAdd.from
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public String toAdd(Model model){
		//��ȡprivilege.xml�е�Ȩ����Ϣ
		List<Privilege> list = PrivilegeReader.getPrivileges();
		model.addAttribute("pris", list);
		return "role/roleadd";//����fee/feeadd.jsp
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@Transactional
	public String add(
		@RequestParam("name") String name,
		@RequestParam("pri") Integer[] priIds,
		HttpSession session){
		//����daoд��role��role_module��
		Role role = new Role();
		role.setName(name);
		dao.addRole(role);
		RoleModule roleModule = new RoleModule();
		for (Integer id : priIds) {
			roleModule.setRole_id(role.getRole_id());
			roleModule.setModule_id(id);
			dao.addRoleModule(roleModule);
		}
		return "redirect:/role/list/1";
	}
}
