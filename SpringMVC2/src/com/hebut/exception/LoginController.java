package com.hebut.exception;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@SessionAttributes("name")
public class LoginController extends BasedException{
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String checkLogin3(User user,ModelMap model){
		System.out.println("check");
		String s = null;
		s.length();
		if("sun".equals(user.getUsername())&&"123".equals(user.getPassword())){
			//正确，进入welcome.jsp页面
			model.addAttribute("name",user.getUsername());
			return "welcome";
		}else{
			//错误，进入login.jsp
			return "login";
		}
	}
	//该方式的优先级最高，其他的谁靠前谁先执行
//	@ExceptionHandler
//	public String myException(HttpServletRequest req,Exception ex){
//		//当LoginController有异常，记录异常，并转到error.jsp
//		System.out.println("记录了异常信息"+ex);
//		return "error";
//	}

}
