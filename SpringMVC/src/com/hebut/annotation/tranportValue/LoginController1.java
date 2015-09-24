package com.hebut.annotation.tranportValue;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login11")
@SessionAttributes("name")
public class LoginController1 {
	
	@RequestMapping("/toLogin2")
	public String toLogin2(){
		return "login2";
	}
	
	@RequestMapping("/toLogin3")
	public String toLogin3(){
		return "login3";
	}
	@RequestMapping("/toLogin4")
	public String toLogin4(){
		return "login4";
	}
	
	
	@RequestMapping("/login2")
	public ModelAndView checkLogin2(User user){
		System.out.println("check111111111---");
		if("sun".equals(user.getUsername())&&"123".equals(user.getPassword())){
			//正确，进入welcome.jsp页面
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", user.getUsername());
			ModelAndView mav = new ModelAndView("welcome",map);
			return mav;
		}else{
			//错误，进入login.jsp
			
			return new ModelAndView("login2");
		}
	}
	@RequestMapping("/login3")
	public String checkLogin3(User user,ModelMap model){
		System.out.println("check333333---");
		if("sun".equals(user.getUsername())&&"123".equals(user.getPassword())){
			//正确，进入welcome.jsp页面
			HashMap<String, Object> map = new HashMap<String, Object>();
			model.addAttribute("name",user.getUsername());
			return "welcome";
		}else{
			//错误，进入login.jsp
			
			return "login3";
		}
	}
	//参数中ModelAttribute晚于SessionAttribte，将user对象放入ModelMap中
	@RequestMapping("/login4")
	public String checkLogin4(@ModelAttribute("name") User user){
		System.out.println("check444444---");
		System.out.println(user.getUsername());
		if("sun".equals(user.getUsername())&&"123".equals(user.getPassword())){
			//正确，进入welcome.jsp页面
			return "welcome4";
		}else{
			//错误，进入login.jsp
			return "login4";
		}
	}
	
	@ModelAttribute("name")
	public User getUser(){//早于sessionAttribute，将user对象放入ModelMap中
		return new User();
	}
	/**
	 * 执行过程
	 * 1. request.setAttribute("name",new User())
	 * 2. session.setAttribute("name",new User())
	 * 3. session.setAttribute("name",user)
	 */
}
