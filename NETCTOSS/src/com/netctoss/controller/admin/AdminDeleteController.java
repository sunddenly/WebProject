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
import com.netctoss.util.PrivilegeReader;

@Controller
@RequestMapping("/admin")
public class AdminDeleteController {
	@Resource
	private AdminInfoMapperDao adminDao;
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public boolean execute(@PathVariable(value="id") Integer id){
		if(id!=null){
			adminDao.deleteAdminRoleById(id);
			adminDao.deleteAdminById(id);
			return true;
		}
		return false;
	}
}
