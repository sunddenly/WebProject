package com.hebut.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jxy on 2016/6/11.
 */
public class LoginHandler implements HttpRequestHandler {

    public void handleRequest(HttpServletRequest request,
                              HttpServletResponse response
    ) throws ServletException, IOException {
        request.getSession().setAttribute("info","mvc-xml-view HttpRequestHandler");
        //原始转发方式
        ServletContext sc = request.getSession().getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/WEB-INF/views/index.jsp");
        dispatcher.forward(request,response);
        //原始重定向还未能实现
//        response.sendRedirect("/mvc-xml/default/index.jsp");
    }
}
