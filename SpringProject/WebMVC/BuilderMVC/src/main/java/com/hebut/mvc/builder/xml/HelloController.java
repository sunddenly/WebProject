package com.hebut.mvc.builder.xml;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jxy on 2016/6/6.
 */
public class HelloController implements Controller {
    public ModelAndView handleRequest(
            HttpServletRequest req,
            HttpServletResponse resq)throws Exception{
        System.out.println("处理hello.from请求");
        ModelAndView mv = new ModelAndView("hello");
        return mv;//调用hello.jsp
    }
}
