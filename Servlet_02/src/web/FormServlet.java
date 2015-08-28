package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取相应表单
 * @author hdoop
 * 1. 设置输出的内容
 * 2. 获取输出流
 * 3. 获取提交到文本框中的数据
 * 4. 输出指定信息
 * 5. 关闭流
 */
public class FormServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		//设置输出内容格式
		response.setContentType("text/html;charset=utf-8");
		//设置解码格式
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("textName");
		out.println("<h1>Hello "+name+"</h1>");
		
		String[] hobbys = request.getParameterValues("hobby");
		if(hobbys!=null){
			out.println("Hobbys：");
			for (String str : hobbys) {
				out.println(str+"<br/>");
			}
		}
		out.close();
	}

}
