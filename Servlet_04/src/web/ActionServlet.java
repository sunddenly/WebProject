package web;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.EmployeeDAO;
import entity.Employee;

import java.io.*;
import java.util.List;
/**
 * servelt 请求分发
 * @author hdoop
 * 所有.do结尾的请求都将交给service方法处理
 * 所以要获取URI,判断请求操作
 * 进行分发
 */
public class ActionServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//获取uri/appName/addemp.do
		String uri = request.getRequestURI();
		//截取后缀do前的字符
		uri = uri.substring(
				uri.lastIndexOf("/"),
				uri.lastIndexOf(".")
				);
		//不同动作分发
		if(uri.equals("/listemp")){
			//查询操作
			EmployeeDAO dao =null;
			List<Employee> emps = null; 
			
			try {
				dao = new EmployeeDAO();
				emps = dao.findAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//显示结合数据到表格
			out.println("<html><head>");
			out.println("</head><body>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>编号</td>");
			out.println("<td>姓名</td>");
			out.println("<td>工资</td>");
			out.println("<td>年龄</td>");
			out.println("<td>操作</td>");
			out.println("</tr>");
			for (Employee emp : emps) {
				out.println("<tr>");
				out.println("<td>"+emp.getId()+"</td>");
				out.println("<td>"+emp.getName()+"</td>");
				out.println("<td>"+emp.getSalary()+"</td>");
				out.println("<td>"+emp.getAge()+"</td>");
				out.println("<td>"+
							"<a href='delemp.do?id="+emp.getId()+"'>删除</a></td>");
				out.println("<td>"+
						"<a href='loademp.do?id="+emp.getId()+"'>修改</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
		}else if(uri.equals("/addemp")){
			//增加操作
			//获取表单提交数据
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			/**
			 * 1. 将数据生成一个Employee对象
			 * 2. 实例化一个DAO对象
			 * 3. 调用dao对象的save方法实现保存
			 * 4. 使用重定向跳转到/listemp.do
			 */
			try{
				Employee emp = new Employee();
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				
				EmployeeDAO dao = new EmployeeDAO();
				dao.save(emp);
				response.sendRedirect("listemp.do");
				//增加功能从addemp.html页面开始
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(uri.equals("/delemp")){
			//获取地址栏中的隐藏id
			int id = Integer.parseInt(request.getParameter("id"));
			//调用dao方法执行删除动作
			try {
				EmployeeDAO dao = new EmployeeDAO();
				dao.delete(id);
				response.sendRedirect("listemp.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(uri.equals("/loademp")){
			//获取地址栏中的隐藏id
			int id = Integer.parseInt(request.getParameter("id"));
			//调用dao方法执行删除动作
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee emp = dao.findById(id);
				//显示表单
				out.println("<html><head></head><body>" +
						"<form action='modifyemp.do' method='post'>");
				out.println("编号："+id+"<br/>");
				//隐藏表单域
				out.println("<input type='hidden' name='id' value='"+id+"'/><br/>");
				out.println("姓名：<input name='name' value='"+emp.getName()+"'/><br/>");
				out.println("薪水：<input name='salary' value='"+emp.getSalary()+"'/><br/>");
				out.println("年龄：<input name='age' value='"+emp.getAge()+"'/><br/>");
				out.println("年龄：<input type='submit' value='保存'/><br/>");
				out.println("</form></body></html>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(uri.equals("/modifyemp")){
			/**
			 * 获取表单数据
			 * 封装到emp对象
			 * 调用dao的modify方法
			 * 修改后需要重定向到查询结果
			 */
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
				e.printStackTrace();
			}
		}
		
	}
}
