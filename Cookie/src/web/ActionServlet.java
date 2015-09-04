package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;
/**
 * 用户登录注册
 * @author hdoop
 *
 */
public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.indexOf("."));
		if(uri.equals("/regist")){
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			UserDao dao = new UserDao();
			try {
				User user = dao.findByUserName(username);
				if(user != null){
					request.setAttribute("regist_error", "用户名已经存在！");
					request.getRequestDispatcher("regist.jsp").forward(request, response);
				}else{
					user = new User(username, pwd, name, gender);
					dao.save(user);
					response.sendRedirect("login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(uri.equals("/login")){
			String username = request.getParameter("username");
			String password = request.getParameter("pwd");
			UserDao dao = new UserDao();
			User user = null;
			try {
				user = dao.findByUserName(username);
				if(user == null||!user.getPwd().equals(password)){
					request.setAttribute("login_error", "用户名或密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else{
					response.sendRedirect("listemp.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}

}
