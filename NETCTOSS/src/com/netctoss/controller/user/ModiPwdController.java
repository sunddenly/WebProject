package com.netctoss.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;

@Controller
@RequestMapping("/user")
public class ModiPwdController {
	@Resource
	private AdminInfoMapperDao dao;
	@RequestMapping(value="/toModiPwd",method=RequestMethod.GET)
	public String toModiPwd(){//默认显示第1条，一页5条
		return "user/usermodipwd";
	}
	
	@RequestMapping(value="/ModiPwd",method=RequestMethod.POST)
	@ResponseBody
	public boolean ModiPwd(
			String oldpwd,
			String newpwd,
			HttpSession session){//默认显示第1条，一页5条
		String adminCode = (String)session.getAttribute("user");
		AdminInfo admin = new AdminInfo();
		admin.setAdmin_code(adminCode);
		admin.setPassword(oldpwd);
		AdminInfo qinfo = dao.findByAdminCodeAndPwd(admin);
		if(qinfo != null){
			admin.setPassword(newpwd);
			dao.modiPwd(admin);
			return true;
		}
		return false;
	}
	
}
