package com.netctoss.controller.role;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.RoleMapperDao;

@Controller
@RequestMapping("/role")
@Transactional
public class RoleDeleteController {
	@Resource
	private RoleMapperDao dao;
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	@ResponseBody//以json方式返回
	public boolean execute(@PathVariable(value="id") Integer id){
		if(id!=null){
			dao.deleteRoleModuleById(id);
			dao.deleteRoleById(id);
		}
		return true;
	}
}
