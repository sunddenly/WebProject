package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import bean.People;

public class ServerServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if(uri.equals("/getInfo")){
			People p = new People("sun",123);
			JSONObject obj = JSONObject.fromObject(p);
			String str = obj.toString();
			out.println(str);
		}else if(uri.equals("/sendInfo")){
			String jstr = request.getParameter("json");
			JSONObject obj = JSONObject.fromObject(jstr);
			People p = (People) obj.toBean(obj,People.class);
			System.out.println(p);
		}
		out.close();
	}

}
