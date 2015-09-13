package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter {
	private String keyword = null;
	/**
	 * 在容器销毁过滤器实例时调用的方法
	 * 值调用一次
	 */
	public void destroy() {

	}
	/**
	 * 用于设置过滤的具体逻辑，该方法有三个参数
	 * 1. arg0: 拦截请求时获取的请求对象，即request
	 * 2. arg1: 与拦截请求对象的响应对象，即response
	 * 3. arg2: 过滤器链对象FilterChain,该对象可以决定是将请求传给后续的servlet，还是直接响应，终止后续处理
	 */
	public void doFilter(
			ServletRequest arg0, 
			ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//转换参数为HttpServlet类型
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取请求提交的评论信息
		String comm = request.getParameter("comment");
		//判断评论中那个是否包含敏感字眼
		PrintWriter out = response.getWriter();
		if(comm.indexOf(keyword)!=-1){
			out.println("评论已经关闭");
		}else{
			/**
			 * 如果没有敏感词，继续交给后续其他组件处理
			 * 即调用doFilter代表放行
			 */
			arg2.doFilter(request, response);
			out.println("胡萝卜");
		}
	}
	/**
	 * 在容器启动时，容器立即创建Filter的实例
	 * 创建实例后，会把已经准备好的FilterConfig对象传给init()方法
	 * 值调用一次init方法
	 * 通过FilterConfig可以获取配置中有关该过滤器的一些初始化参数
	 */
	public void init(FilterConfig arg0) throws ServletException {
			keyword = arg0.getInitParameter("word");
	}

}
