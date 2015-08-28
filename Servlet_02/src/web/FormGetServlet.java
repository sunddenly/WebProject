package web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * 以Get方式提交表单字符集
 * @author hdoop
 * 1. 设置输出内容格式
 * 2. 设置信息解码方式
 * 3. 获取输出流
 * 4. 获取请求包中提交的数据
 * 5. 针对get方式中的中文进行编码重组
 * 6. 向页面输出内容
 */
public class FormGetServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		//1.设定浏览器以UTF-8格式打开，支持中文
		response.setContentType("text/html;charset=utf-8");
		//2.
		request.setCharacterEncoding("UTF-8");
		//3.
		PrintWriter out = response.getWriter();
		//4.
		String namestr = request.getParameter("textName");
		String agestr = request.getParameter("textAge");
		//5.
		String name = new String(namestr.getBytes("iso-8859-1"),"UTF-8");
		int age = Integer.parseInt(agestr);
		//6.
		out.println("姓名："+name+"<br/>年龄："+age);
		out.close();
	}
}
