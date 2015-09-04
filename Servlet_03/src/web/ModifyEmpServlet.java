package web;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ModifyEmpServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		//1.获取提交数据
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		//2.jdbc修改
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","hadoop");
			pstmt = conn.prepareStatement("UPDATE t_emp SET name=?,salary=?,age=? WHERE id=?");
			pstmt.setString(1, name);
			pstmt.setDouble(2, salary);
			pstmt.setInt(3, age);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			//重定向查看
			response.sendRedirect("listemp");
		}catch(Exception e){
			
		}finally{
			if(conn != null){
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
