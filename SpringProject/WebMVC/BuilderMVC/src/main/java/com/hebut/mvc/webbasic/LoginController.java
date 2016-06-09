package com.hebut.mvc.webbasic;

import com.hebut.mvc.webbasic.ioc.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by jxy on 2016/6/7.
 */
@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {
    @Resource//请求Spring注入资源userService
    private UserService userService;
    @RequestMapping("/login.form")
    public String loginForm(){
        //可以向表单传递一些参数
        return "login-form";//映射到login-form.jsp
    }
    //Spring MVC 自动注入HttpServletRequest 参数
    //优点，简单直接; 缺点：需要自己处理类型转换
    @RequestMapping("/login-action1.form")
    public String checkLogin1(HttpServletRequest req){
        System.out.println("----方法一----");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        try{
            User user = userService.login(name, pwd);
            //登录成功后将信息保存到当前会话中
            req.getSession().setAttribute("user",user);
            return "success";
        }catch (NameOrPwdException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "login-form";
        }catch (NullParamException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "login-form";
        }catch (RuntimeException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "error";
        }
    }

    @RequestMapping("/login-action2.form")
    public String checkLogin2(//Spring MVC会自动将表单参数注入
            String name,//Spring 默认注入名称与方法形参不一致时，用RequestParam注入
            @RequestParam("pwd") String password,
            HttpServletRequest req){
        System.out.println("----方法二----");
        //优点：自动进行类型转换;缺点：可能出现转换异常
        System.out.println(name);
        System.out.println(password);
        try{
            User user = userService.login(name, password);
            //登录成功后将信息保存到当前会话中
            req.getSession().setAttribute("user",user);
            return "success";
        }catch (NameOrPwdException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "login-form";
        }catch (NullParamException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "login-form";
        }catch (RuntimeException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "error";
        }
    }
    @RequestMapping("/login-action3.form")
    public String checkLogin3(
            User user,//Spring 自动注入bean对象
            HttpServletRequest req){
        System.out.println("----方法三----");
        //优点：自动进行类型转换;缺点：可能出现转换异常
        System.out.println(user);
        try{
            user = userService.login(user.getName(), user.getPwd());
            //登录成功后将信息保存到当前会话中
            req.getSession().setAttribute("user",user);
            return "success";
        }catch (NameOrPwdException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "login-form";
        }catch (NullParamException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "login-form";
        }catch (RuntimeException e){
            e.printStackTrace();
            req.setAttribute("message",e.getMessage());
            return "error";
        }
    }
    @RequestMapping("/login-action4.form")
    public ModelAndView checkLogin4(
            String name,
            String pwd,
            HttpServletRequest req){
        System.out.println("----方法四----");
        Map<String, Object> data = new HashMap<String, Object>();
        try{
            User user = userService.login(name, pwd);
            //登录成功后将信息保存到当前会话中
            req.getSession().setAttribute("user",user);
            return new ModelAndView("success",data);
        }catch (NameOrPwdException e){
            data.put("message",e.getMessage());
            return new ModelAndView("login-form",data);
        }catch (NullParamException e){
            data.put("message",e.getMessage());
            return new ModelAndView("login-form",data);
        }catch (RuntimeException e){
            data.put("message",e.getMessage());
            return new ModelAndView("error",data);
        }
    }
    @RequestMapping("/login-action5.form")
    public String  checkLogin5(
            @ModelAttribute("name") String name,
            @ModelAttribute("pwd")String pwd,//@ModelAttribute("password")String pwd,无法将表单数据注入到pwd
            ModelMap model,
            HttpServletRequest req){
        System.out.println("----方法五----");
        System.out.println(name);
        System.out.println(pwd);
        try{
            User user = userService.login(name, pwd);
            //登录成功后将信息保存到当前会话中
            req.getSession().setAttribute("user",user);
            return "success";
        }catch (NameOrPwdException e){
            model.addAttribute("message",e.getMessage());
            return "login-form";
        }catch (NullParamException e){
            model.addAttribute("message",e.getMessage());
            return "login-form";
        }catch (RuntimeException e){
            model.addAttribute("message",e.getMessage());
            return "error";
        }
    }
    private String[] msg = {"再来一次","下次就对了","没有关系还有机会"};
    @ModelAttribute("next")
    public String getNext(){
        Random r = new Random();
        return msg[r.nextInt(msg.length)];
    }

    @RequestMapping("/login-action6.form")
    public String checkLogin6(
            String name,
            String pwd,
            HttpServletRequest req){
        System.out.println("----方法六----");
        Map<String, Object> data = new HashMap<String, Object>();
        try{
            User user = userService.login(name, pwd);
            //登录成功后将信息保存到当前会话中
            //req.getSession().setAttribute("user",user);
            return"success";
        }catch (NameOrPwdException e){
            data.put("message",e.getMessage());
            return "login-form";
        }catch (NullParamException e){
            data.put("message",e.getMessage());
            return "redirect:login.form";
        }catch (RuntimeException e){
            data.put("message",e.getMessage());
            return "error";
        }
    }
}
