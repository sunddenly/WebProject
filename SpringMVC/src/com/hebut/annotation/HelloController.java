package com.hebut.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//默认是/hello.from,即后缀名默认web.xml中的后缀名
	@RequestMapping("/hello")
	public String execute(){
		return "hello";
	}
}
