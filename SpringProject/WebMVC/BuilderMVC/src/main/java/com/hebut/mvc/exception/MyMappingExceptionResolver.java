package com.hebut.mvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//自定义异常解析器
public class MyMappingExceptionResolver implements HandlerExceptionResolver{
    public ModelAndView resolveException(
            HttpServletRequest req,
            HttpServletResponse res,
            Object handler,
            Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex",ex);
        //根据不同的错误转向不同的页面
        return new ModelAndView("error",model);
    }
}
