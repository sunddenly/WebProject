package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Comment2Filter implements Filter{
	int len = 0;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//提交表单内容
		String comm = request.getParameter("comment");
		//长度不能超过20
		if(comm.length()>20){
			out.println("<h1>好长</h1>");
		}else{
			chain.doFilter(request, response);
			out.println("长度");
		}
	}

	public void init(FilterConfig config) throws ServletException {
		len = Integer.parseInt(config.getInitParameter("length"));
	}

}
