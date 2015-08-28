package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		//设置服务器返回的数据类型以及编码方式
		response.setContentType("text/html;charset=utf-8");
		//设置服务器端的解码方式
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "hadoop");
		    pstmt = conn.prepareStatement("INSERT INTO t_emp VALUES(null,?,?,?)");
		    pstmt.setString(1, name);
		    pstmt.setDouble(2, salary);
		    pstmt.setInt(3, age);
		    pstmt.executeUpdate();
		    //使用重定向，查看员工信息
		    //发回的是302状态码和location消息头
		    response.sendRedirect("listemp");
		} catch (Exception e) {
			out.println("系统异常请稍后......");
			e.printStackTrace();
		} finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		out.println("添加成功！");
		out.close();
	}
}
