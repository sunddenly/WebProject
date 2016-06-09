package com.hebut.mvc.builder.annotation;


import com.hebut.mvc.exception.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/hello")
class HelloController extends BaseController{
    @RequestMapping("/hello.form")
    public String execute()throws Exception{
        //制造控制指针
        String s=null;
        s.length();
        System.out.println("HelloController执行");
        return "hello";
    }
}
