package com.netctoss.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.RoleMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.AdminRole;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;
import com.netctoss.entity.Privilege;
import com.netctoss.entity.Role;
import com.netctoss.entity.RoleModule;
import com.netctoss.util.PrivilegeReader;

@Controller
@RequestMapping("/admin")
public class AdminAddController {
	@Resource
	private RoleMapperDao roleDao;
	@Resource
	private AdminInfoMapperDao adminDao;
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public String toAdd(Model model){
		//��ȡrole_info���еĽ�ɫ��Ϣ
		List<Role> list = roleDao.findRoleAll();
		model.addAttribute("roles", list);
		return "admin/adminadd";//����fee/feeadd.jsp
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@Transactional
	public String add(
		AdminInfo admin,
		@RequestParam("roleIds") Integer[] Ids){
		//����daoд��admin��admin_role��
		adminDao.addAdmin(admin);
		for (Integer id : Ids) {
			AdminRole adminRole = new AdminRole();
			adminRole.setAdmin_id(admin.getAdmin_id());
			adminRole.setRole_id(id);
			adminDao.addAdminRole(adminRole);
		}
		return "redirect:/admin/list/-1/*/1";
	}
}
