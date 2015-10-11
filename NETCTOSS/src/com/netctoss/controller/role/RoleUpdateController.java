package com.netctoss.controller.role;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
public class RoleUpdateController {
	@Resource
	private RoleMapperDao dao;
	
	@RequestMapping(value="/{id}/toEdit",method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public String toUpdate(
			@PathVariable(value="id") Integer id,
			Model model){
		//加载Role
		Role role = dao.findById(id);
		//加载role.priIds的权限ID信息
		List<Integer> priList = dao.findModuleIdByRoleId(id);
		role.setPriIds(priList);
		model.addAttribute("role", role);
		return "role/rolemodi";
	}
	//该标记方法在toUpdate前执行相当于model.addAttribute("pris", list);
	@ModelAttribute("pris")
	public List<Privilege> loadPrivilege(){
		//提取权限信息，用于生成checkbox
		List<Privilege> list = PrivilegeReader.getPrivileges();
		return list;
	}
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@Transactional
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam("name") String name,
			@RequestParam("priIds") Integer[] priIds){
		Role role = new Role();
		role.setRole_id(id);
		role.setName(name);
		//获取更新记录，调用dao更新
		dao.updateRole(role);
		dao.deleteRoleModuleById(id);
		RoleModule roleModule = new RoleModule();
		for (Integer priId : priIds) {
			roleModule.setRole_id(id);
			roleModule.setModule_id(priId);
			dao.addRoleModule(roleModule);
		}
		return "redirect:/role/list/1";
	}
}
