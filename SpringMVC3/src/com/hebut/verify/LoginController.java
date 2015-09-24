package com.hebut.verify;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx.Binding;

@Controller
@RequestMapping("/login")
public class LoginController{
	
	@RequestMapping("/toLogin")
	public String toLogin(Model model){
		model.addAttribute("user",new User());
		return "login";
	}
	/**
	 * 将校验逻辑和主逻辑分开
	 */
	@RequestMapping("/login")
	public String checkLogin(@Valid User user,BindingResult errors,ModelMap model){
		//判断是否校验有错误
		if(errors.hasErrors()){
			//有错误，表明用户表单输入有误，返回login
			return "login";
		}
		model.addAttribute("user",user);
		if("sun".equals(user.getUsername())&&"123456".equals(user.getPassword())){
			//正确，进入welcome.jsp页面
			return "welcome";
		}else{
			//错误，进入login.jsp
			return "login";
		}
	}
}
