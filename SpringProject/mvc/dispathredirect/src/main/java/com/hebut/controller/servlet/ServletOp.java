package com.hebut.controller.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jxy on 2016/6/11.
 */
@RequestMapping("/servlet")
@Controller
public class ServletOp {
    @RequestMapping("/dispatch.form")
    public void dispatch(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("info","servlet 转发请求");
        RequestDispatcher dispatcher = req.getSession().getServletContext().getRequestDispatcher("/spring/index.form");
        dispatcher.forward(req,res);
        //return;
    }
    @RequestMapping("/dispatch/root.form")
    public void dispatch22(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("info","servlet 转发视图");
        RequestDispatcher dispatcher = req.getSession().getServletContext().getRequestDispatcher("/WEB-INF/web-info.jsp");
        dispatcher.forward(req,res);
        //return;
    }
    @RequestMapping("/redirect.form")
    public void redirect(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().setAttribute("info","servlet 重定向");
        res.sendRedirect("/mvc-req/spring/index.form");
        return;
    }
}
