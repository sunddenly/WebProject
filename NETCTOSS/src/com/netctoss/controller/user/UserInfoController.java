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
public class UserInfoController {
	@Resource
	private AdminInfoMapperDao dao;
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String execute(HttpSession session,Model model){//默认显示第1条，一页5条
		String name = (String) session.getAttribute("user");
		AdminInfo info = dao.findByName(name);
		model.addAttribute("userInfo",info);
		return "user/userinfo";
	}
}
