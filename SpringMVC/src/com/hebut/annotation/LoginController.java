package com.hebut.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestScope;

import com.hebut.annotation.tranportValue.User;
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/toLogin1")
	public String toLogin1(){
		return "login1";
	}
	
	@RequestMapping("/toLogin2")
	public String toLogin2(){
		System.out.println("login2----");
		return "login2";
	}
	
	@RequestMapping("/login")
	public String checkLogin(HttpServletRequest request){
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		if("sun".equals(username)&&"123".equals(pwd)){
			//正确，进入welcome.jsp页面
			return "welcome";
		}else{
			//错误，进入login.jsp
			return "login";
		}
	}
	
	@RequestMapping("/login1")
	public String checkLogin1(
			@RequestParam(value="username",required=false) String username,
			@RequestParam(value="password",required=false) String pwd){
		System.out.println("check1");
		if("sun".equals(username)&&"123".equals(pwd)){
			//正确，进入welcome.jsp页面
			return "welcome";
		}else{
			//错误，进入login.jsp
			return "login1";
		}
	}
	
	@RequestMapping("/login2")
	public String checkLogin2(User user){
		System.out.println("check2---");
		if("sun".equals(user.getUsername())&&"123".equals(user.getPassword())){
			//正确，进入welcome.jsp页面
			return "welcome";
		}else{
			//错误，进入login.jsp
			return "login2";
		}
	}
}
