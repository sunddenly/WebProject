package com.netctoss.controller.login;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.entity.AdminInfo;

@Controller
@RequestMapping("/logout")
public class LoginOutController {
	@Resource
	private AdminInfoMapperDao dao;
	@RequestMapping(value="/toLogout",method=RequestMethod.GET)
	public String logout(
			HttpSession session){
		session.removeAttribute("user");
		return "redirect:../login/toLogin";
	}
}
