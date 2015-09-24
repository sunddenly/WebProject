package com.hebut;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.ControllerEventListener;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	//默认处理请求的方法
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		//处理业务逻辑，可以调用Dao
	    //调用View视图组件名，hello.jsp为hello
		ModelAndView mav = new ModelAndView("hello");
		return mav;
	}
	
}
