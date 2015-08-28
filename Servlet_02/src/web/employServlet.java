package web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 收集员工信息，提交到服务器
 * @author hdoop
 *
 */
public class employServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		//out.println("姓名："+name+"<br/>薪水："+salary+"<br/>年龄："+age);
		//out.close();
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
