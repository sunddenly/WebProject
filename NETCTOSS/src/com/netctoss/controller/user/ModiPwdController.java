package com.netctoss.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;

@Controller
@RequestMapping("/user")
@Transactional(readOnly=true)
public class ModiPwdController {
	@Resource
	private AdminInfoMapperDao dao;
	@RequestMapping(value="/toModiPwd",method=RequestMethod.GET)
	public String execute(){//Ĭ����ʾ��1����һҳ5��
		return "user/usermodipwd";
	}
}
