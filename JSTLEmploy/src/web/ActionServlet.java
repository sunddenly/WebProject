package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.UserDao;
import entity.Employee;
import entity.User;
/**
 * 员工信息管理系统
 * @author hdoop
 * 1. 查询功能
 * 	1.1 获取URI
 *  1.2 截取URI动作
 *  1.3 dao获取数据
 *  1.4 绑定数据
 *  1.5 转发数据到listemp.jsp
 * 2. 增加功能
 *  2.1 修改listEmp.jsp中"增加员工"按钮的连接
 *  2.2 新建addEmp.jsp页面
 *  2.3 修改表单的action为"addemp.do"
 *  2.4 修改表单中个个文本框中的名称
 *  2.5 在ActionServlet中添加"addemp"分支
 *  2.6 获取表单提交的数据，封装到emp对象中
 *  2.7 实例化dao对象，调用save方法
 *  2.8 重定向到listemp.do
 * 3. 删除功能
 * 	3.1  在listEmp.jsp页面"添加","删除"修改操作
 *  3.2 修改删除修改链接，分别加入隐藏id
 *  3.3 在ActionServlet加入delemp分支
 *  3.4 获取请求参数，即删除记录id
 *  3.5 创建dao,调用delete()方法删除记录
 *  3.6 重定向到listemp.do
 * 4. 修改功能
 * 	4.1 加载修改信息
 * 		4.1.1 创建UpdateEmp.jsp页面，显示加载信息
 * 		4.1.2 修改UpdateEmp.jsp页面的action为post
 *      4.1.3 在UpdateEmp.jsp加入隐藏表单，即id
 *      4.1.4 在ActionServlet加入loademp分支
 *      4.1.5 请求的隐藏id
 *      4.1.6 新建dao调用findEmpById(id)，获取修改记录信息
 *      4.1.7 转发到UpdatEmp.jsp页面显示
 *  4.2 更新修改信息
 *  	4.2.1 获取UpdateEmp.jsp页面提交的表但数据
 *  	4.2.2 新建dao调用modify(id)将修改写入数据库
 *  	4.2.3 重定向到listemp.do
 */
public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.indexOf("."));
		if(uri.equals("/listemp")){
			try{
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> emps = dao.findAll();
				request.setAttribute("allEmp", emps);
				//一般在这用转发，不用重定向
				request.getRequestDispatcher("listEmp.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("msg", "系统繁忙");
				request.getRequestDispatcher("err.jsp").forward(request, response);
			}
		}else if(uri.equals("/addemp")){
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			Employee emp = new Employee(0, name, salary, age);
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.save(emp);
				response.sendRedirect("listemp.do");
			} catch (Exception e) {
				e.printStackTrace();
				//将异常抛给容器
				throw new ServletException(e);
			}
		}else if(uri.equals("/delemp")){
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.delete(id);
				response.sendRedirect("listemp.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(uri.equals("/loademp")){
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDAO dao = new EmployeeDAO();
			try {
				Employee emp = dao.findById(id);
				request.setAttribute("EmpInfo", emp);
				request.getRequestDispatcher("UpdateEmp.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(uri.equals("/modifyemp")){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			Employee emp = new Employee(id, name, salary, age);
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.modify(emp);
				response.sendRedirect("listemp.do");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(uri.equals("/regist")){
			String incode = request.getParameter("incode");
			HttpSession session = request.getSession();
			String checkcode = session.getAttribute("checkcode").toString();
			if(!incode.equalsIgnoreCase(checkcode)){
				request.setAttribute("checkmsg", "验证码错误");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
				return ;
			}
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
			String incode = request.getParameter("incode");
			HttpSession session = request.getSession();
			String checkcode = session.getAttribute("checkcode").toString();
			if(!incode.equalsIgnoreCase(checkcode)){
				request.setAttribute("checkmsg", "验证码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return ;
			}
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
					session.setAttribute("uname", username);
					response.sendRedirect("listemp.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(uri.equals("/logout")){
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
	}

}
