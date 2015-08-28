package web;
import java.io.IOError;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.imageio.*;
/**
 * Request 获取请求包中的数据
 * @author hdoop
 *
 */
public class RequestServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		//设置输出中文
		response.setContentType("text/html;charset=utf-8");
		
		//获取所有的消息头
		Enumeration enu = request.getHeaderNames();
		while(enu.hasMoreElements()){
			//依次获取每个消息头的名称
			String name = enu.nextElement().toString();
			String value = request.getHeader(name);
			System.out.println(name+":"+value);
		}
		//获取URI:请求资源路径
		String uri = request.getRequestURI();
		//获取URL:包含URI
		StringBuffer url = request.getRequestURL();
		System.out.println("url:"+url+"\n"+"uri:"+uri);
	}
}
