package com.hebut.mvc.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jxy on 2016/6/8.
 */
public class FirstIntercept implements HandlerInterceptor {
    public void afterCompletion(HttpServletRequest req,
                                HttpServletResponse res,
                                Object handler,
                                Exception e) throws Exception {
        System.out.println("[First] afterCompletion");
    }
    public void postHandle(HttpServletRequest req,
                           HttpServletResponse res,
                           Object handler,
                           ModelAndView mv) throws Exception {
        System.out.println("[First] postHandle");
    }

    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object Handler) throws Exception {
        System.out.println("[First] preHandle");
        return true;
    }
}
