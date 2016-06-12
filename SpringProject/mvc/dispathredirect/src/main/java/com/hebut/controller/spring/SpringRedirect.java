package com.hebut.controller.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by jxy on 2016/6/11.
 */
@Controller
@RequestMapping("/spring")
public class SpringRedirect {
    //hello.jsp资源在WEB——INF，必须通过转发获取
   @RequestMapping("index.form")
   public String getJsp(){
       return "index";
   }
    //相对路径重定向
    //重定向内容应该是一个请求，而不是页面，页面一般放在WEB-INF下布恩那个直接访问
    @RequestMapping("/redirect/modelview/info.form")
    public ModelAndView redirect(HttpServletRequest request){
        RedirectView view = new RedirectView("/mvc-req/spring/index.form");
        request.getSession().setAttribute("describe","Spring 重定向 session 数据");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("describe","Spring 重定向：model 数据");
        //加上map后会，在请求后附加一些参数传输
        return new ModelAndView(view,map);//当前路径更改请求，info.form改为index.form该重定向方式是错的，应该使用绝对路径
    }
    //相对路径重定向
    //重定向内容应该是一个请求，而不是页面，页面一般放在WEB-INF下布恩那个直接访问
    @RequestMapping("/redirect/realtive/info.form")
    public String redirect1(HttpServletRequest request){
        request.getSession().setAttribute("describe","Spring 重定向");
        return "redirect:index.form";//当前路径更改请求，info.form改为index.form该重定向方式是错的，应该使用绝对路径
    }
    //绝对路径重定向
    //重定向WEB-INF下的页面，需要通过Controller来访问
    @RequestMapping("/redirect/absolute/info.form")
    public String redirect2(HttpServletRequest request){
        request.getSession().setAttribute("describe","Spring 重定向请求到Controller");
        return "redirect:/spring/index.form";//"/"=="/appname/"
    }
    //绝对路径重定向到非WEB-INF资源，如JSP页面
    @RequestMapping("/redirect/absolute/page/info.form")
    public String redirect3(HttpServletRequest request){
        request.getSession().setAttribute("describe","Spring 重定向请求到Controller");
        return "redirect:/welcome/headpage.jsp";//"/"=="/appname/"
    }

}
