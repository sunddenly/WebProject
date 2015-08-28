package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 列出员工信息
 * @author hdoop
 * 
 */
public class ListEmpServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","hadoop");
			pstmt = conn.prepareStatement("SELECT * FROM t_emp");
			/**
			 * 输出员工列表
			 * 1. 输出一部分html标记
			 */
			
			out.println(
				"<html><head></head>"+
				"<caption>员工信息</caption>"+
				"<table><tr><td>编号<td/><td>姓名<td/>" +
				"<td>工资<td/><td>年龄</td><td>操作</td></tr>"
					);
			ResultSet res = pstmt.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String name = res.getString("name");
				double salary = res.getDouble("salary");
				int age = res.getInt("age");
				out.println("<tr>");
				out.println("<td>"+id+"<td/>");
				out.println("<td>"+name+"<td/>");
				out.println("<td>"+salary+"<td/>");
				out.println("<td>"+age+"<td/>");
				//添加删除时，需要隐藏每一条记录的ID
				out.println("<td>"+
						"<a href='delemp?id="+id+"' onclick=\"return confirm('是否确认删除"+name+"？')\">删除</a>"+
						"<td/>");
				out.println("<a href='load?id="+id+"'>修改</a>");
				out.println("</tr>");
			}
			out.println("</table></body>"+
					"<a href='addemp.html'>增加员工</a>"
					);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
