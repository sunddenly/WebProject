package com.netctoss.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.entity.AdminInfo;

@Controller
@RequestMapping("/login")
public class CheckLoginController {
	@Resource
	private AdminInfoMapperDao dao;
	@RequestMapping(value="/login/{code}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> login(
			@PathVariable("code") String code,
			@RequestHeader("name") String name,
			@RequestHeader("password") String password,
			HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("login", false);//将标识设置登陆失败
		
		//检查验证码
		String scode = (String) session.getAttribute("scode");
		if(!code.equalsIgnoreCase(scode)){
			//验证码错误
			map.put("codeError", "验证码错误！");
			return map;
		}
		//查询账号和密码
		AdminInfo admin = new AdminInfo();
		admin.setAdmin_code(name);
		admin.setPassword(password);
		AdminInfo info = dao.findByAdminCodeAndPwd(admin);
		if(info!=null){//有记录
			session.setAttribute("user", admin.getAdmin_code());
			map.put("login", true);
			return map;
		}else{//无记录
			map.put("error", "用户名或密码错误，请重试...");
			return map;
		}
	}
}
