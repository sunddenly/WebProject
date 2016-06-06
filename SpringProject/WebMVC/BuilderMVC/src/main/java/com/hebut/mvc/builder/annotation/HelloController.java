package com.hebut.mvc.builder.annotation;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/hello")
class HelloController {
    @RequestMapping("/hello.from")
    public String execute()throws Exception{
        return "hello";
    }
}
