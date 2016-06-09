package com.hebut.mvc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by jxy on 2016/6/8.
 */
public class BaseController implements Serializable {
    @ExceptionHandler
    public String execute(HttpServletRequest request,Exception ex){
        request.setAttribute("ex",ex);
        request.setAttribute("message",ex.getMessage());
        System.out.println(ex.getMessage());
        //可根根据异常类型返回不同的视图名称
        return "error";
    }
}
