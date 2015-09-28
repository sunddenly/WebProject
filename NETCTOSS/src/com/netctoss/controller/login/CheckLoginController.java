package com.netctoss.controller.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.entity.AdminInfo;

@Controller
@RequestMapping("/login")
public class CheckLoginController {
	@Resource
	private AdminInfoMapperDao dao;
	
	@RequestMapping("/login")
	public String login(AdminInfo admin,Model model,HttpSession session){
		//检查验证码
		String scode = (String) session.getAttribute("scode");
		if(!admin.getCode().equalsIgnoreCase(scode)){
			//验证码错误
			model.addAttribute("codeError", "验证码错误！");
			return "login";
		}
		AdminInfo info = dao.findByAdminCodeAndPwd(admin);
		if(info!=null){//有记录
			session.setAttribute("user", admin.getCode());
			return "index";
		}else{//无记录
			model.addAttribute("error", "用户名或密码错误，请重试...");
			return "login";
		}
	}
}
