package com.hebut.controller.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by jxy on 2016/6/11.
 */
@Controller
@RequestMapping("/spring")
public class SpringDispatch {

    //Modelanviewe形式返回
    @RequestMapping("/dispatch/modelview.form")
    public ModelAndView dispatchMV(HttpServletRequest request){
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("info","Spring 转发以ModelAndView形式向浏览器返回视图名");
        ModelAndView mv = new ModelAndView("index",data);//没有放到会话请求结束后数据消失，其他请求不能访问
        return mv;
    }

    //相对路径转发视图
    @RequestMapping("/dispatch/relative.form")
    public String dispatch(HttpServletRequest request){
        request.getSession().setAttribute("info","Spring 转发以 非forward 形式向浏览器返回视图名");
        return "index";
    }

    //绝对路径转发视图
    @RequestMapping("/dispatch/absolute.form")
    public String dispatchAppRoot(HttpServletRequest request){
        request.getSession().setAttribute("info","Spring 转发指定前缀下的资源");
        return "/pages/first";
    }

    //forward标记形式转发视图，该方式可访问wepapp根目录视图
    @RequestMapping("/dispatch/forward/hello.form")
    public String dispatchhello(HttpServletRequest request){
        request.getSession().setAttribute("info","Spring 转发以 forward形式转发到hello.jsp");
        return "forward:/WEB-INF/views/hello.jsp";
    }
    //forward标记形式转发视图，该方式可访问wepapp根目录视图
    @RequestMapping("/dispatch/forward.form")
    public String dispatchWebIfo(HttpServletRequest request){
        request.getSession().setAttribute("info","Spring 转发以 forward形式 webapp根目录视图");
        return "forward:/index.jsp";
    }
    //forward标记形式转发视图，该方式可访问wepapp根目录视图
    @RequestMapping("/dispatch/forward/web-info.form")
    public String dispatch100(HttpServletRequest request){
        request.getSession().setAttribute("info","Spring 转发以 forward形式WEB-INF根目录视图");
        return "forward:/WEB-INF/web-info.jsp";
    }
    //forward标记形式转发视图，该方式可访问wepapp根目录视图
    @RequestMapping("/dispatch/controller.form")
    public String dispatchController(HttpServletRequest request){
        request.getSession().setAttribute("info","Spring 转发到某个Controller");
        return "forward:/spring/index.form";
    }
}
