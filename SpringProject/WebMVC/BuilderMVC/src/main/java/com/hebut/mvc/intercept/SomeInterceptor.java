package com.hebut.mvc.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jxy on 2016/6/7.
 */
public class SomeInterceptor implements HandlerInterceptor {
    public void afterCompletion(HttpServletRequest req,
                                HttpServletResponse res,
                                Object handler,
                                Exception e) throws Exception {
        System.out.println(this.getClass().getName()+"请求处理完成后调用");
    }
    public void postHandle(HttpServletRequest req,
                           HttpServletResponse res,
                           Object handler,
                           ModelAndView mv) throws Exception {
        System.out.println(this.getClass().getName()+"处理器执行后调用");
    }

    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object Handler) throws Exception {
        System.out.println(this.getClass().getName()+"处理器执行前调用");
        return true;
    }
}
