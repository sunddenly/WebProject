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
		//����Role
		Role role = dao.findById(id);
		//����role.priIds��Ȩ��ID��Ϣ
		List<Integer> priList = dao.findModuleIdByRoleId(id);
		role.setPriIds(priList);
		model.addAttribute("role", role);
		return "role/rolemodi";
	}
	//�ñ�Ƿ�����toUpdateǰִ���൱��model.addAttribute("pris", list);
	@ModelAttribute("pris")
	public List<Privilege> loadPrivilege(){
		//��ȡȨ����Ϣ����������checkbox
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
		//��ȡ���¼�¼������dao����
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
