package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 过滤评论中的敏感词
 * @author hdoop
 * 1. 使用表单提交评论，servlet将提交的评论显示
 * 2. 编写实现Filter接口的实现类
 * 		2.1 init()
 *      2.2 destory()
 *      2.3 doFilter()
 *  3. 注册过滤器，在web.xml添加Filter节点
 */
public class CommentServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//获取表单提交的评论
		String comm = request.getParameter("comment");
		out.println("提交的评论是："+comm);
	}

}
