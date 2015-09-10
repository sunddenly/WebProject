package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//返回的内容格式
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if(uri.equals("/getInfo")){
			out.println("Hello moto!");
		}else if(uri.equals("/postInfo")){
			String str = request.getParameter("uname");
			out.println("hello"+str);
		}else if(uri.equals("/checkName")){
			String name = request.getParameter("name");
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
			System.out.println(name);
			if(name.equals("张三")){
				out.println("用户名密码错误");
			}else{
				out.println("可以使用");
			}
		}else if(uri.equals("/getArea")){
			String cityName = request.getParameter("cityName");
			if(cityName.equals("bj")){
				//返回的信息包含两部分
				//区域的中文信息，value属性
				out.println("海淀,hd;朝阳,cy");
			}else if(cityName.equals("sh")){
				out.println("静安,ja;浦东,pd");
			}else{
				out.println("白云,by;番禺,py");
			}
		}
		out.close();
	}

}
