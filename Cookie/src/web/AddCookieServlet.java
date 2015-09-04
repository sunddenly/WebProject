package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie cookie1 = new Cookie("uname", "Kitty");
		cookie1.setMaxAge(200);
		Cookie cookie2 = new Cookie("city", "beijing");
		Cookie cookie3 = new Cookie("address", URLEncoder.encode("π„÷›", "UTF-8"));
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		out.close();
	}

}
