package web;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 为了加载选中的要修改的数据需要
 * 根据url中的id查询对应的数据
 * 显示在表单中，提供修改
 */
public class LoadEmpServlet extends HttpServlet{
	public void service(
			HttpServletRequest request,
			HttpServletResponse response
			)throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","hadoop");
			pstmt = conn.prepareStatement("SELECT * FROM t_emp WHERE id=?");
			pstmt.setInt(1, id);
			res = pstmt.executeQuery();
			while(res.next()){
				int eid = res.getInt("id");
				String name = res.getString("name");
				double salary = res.getDouble("salary");
				int age = res.getInt("age");
				out.println("<html><head>");
				out.println("</head><body>");
				out.println("<form action='modifyemp' method='post'>");
				out.println("编号："+id+"<br/>");
				//添加id的隐藏表单域
				out.println("<input type='hidden' name='id' value='"+id+"'>");
				out.println("姓名：<input name='name' value='"+name+"'/><br/>");
				out.println("薪水：<input name='salary' value='"+salary+"'/><br/>");
				out.println("年龄：<input name='age' value='"+age+"'/><br/>");
				out.println("<input type='submit' value='保存'/>");
				out.println("</form></body></html>");
			}
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
