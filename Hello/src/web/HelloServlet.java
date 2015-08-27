package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 步骤
 * 1. 编写web.HelloServlet源文件
 * 2. 编写web.xml文件
 * 3. 部署应用
 * 4. 启动服务
 */
public class HelloServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String url = req.getRequestURI();
		System.out.println(url);
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello World!你好</h1>");
		out.close();
	}
}
