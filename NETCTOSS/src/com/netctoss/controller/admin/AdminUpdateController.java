package com.netctoss.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.RoleMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.AdminRole;
import com.netctoss.entity.Privilege;
import com.netctoss.entity.Role;
import com.netctoss.util.PrivilegeReader;

@Controller
@RequestMapping("/admin")
public class AdminUpdateController {
	@Resource
	private RoleMapperDao roleDao;
	@Resource
	private AdminInfoMapperDao adminDao;
	@RequestMapping(value="/{id}/toEdit",method=RequestMethod.GET)
	public String toUpdate(
			@PathVariable(value="id") Integer id,
			Model model){
		//����role_info���еĽ�ɫ��Ϣ
		List<Role> list = roleDao.findRoleAll();
		model.addAttribute("roles", list);
		//����admin��Ϣ
		AdminInfo admin = adminDao.findById(id);
		//׷��roleId��Ϣ
		List<Integer> roleIds = adminDao.findRoleId(id);
		admin.setRoleIds(roleIds);
		model.addAttribute("admin",admin);
		return "admin/adminmodi";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String Update(
			AdminInfo admin,
			@PathVariable(value="id") Integer id){
		admin.setAdmin_id(id);
		//����adminInfo
		adminDao.updateAdminInfo(admin);
		
		//ɾ��adminRole�е�admin_id��¼
		adminDao.deleteAdminRoleById(id);
		//��ӹ���Ա�Ľ�ɫ��Ϣ
		AdminRole adminRole = new AdminRole();
		adminRole.setAdmin_id(id);
		List<Integer> list = admin.getRoleIds();
		for (Integer roleId : list) {
			adminRole.setRole_id(roleId);
			adminDao.addAdminRole(adminRole);
		}
		return "redirect:/admin/list/-1/*/1";
	}
}
