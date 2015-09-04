<%@ page import="java.util.*,dao.*,entity.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String uname = (String)session.getAttribute("uname");
	if(uname==null){
		response.sendRedirect("login.jsp");
		return ;
	}
 %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
						<a href="logout.do">注销</a>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami"></p>
					<h1>Welcome!</h1>
					<table class="table">
						<tr class="table_header">
							<td>编号</td>
							<td>姓名</td>
							<td>工资</td>
							<td>年龄</td>
							<td>操作</td>
						</tr>
						<%
							List<Employee> emps = (List<Employee>)request.getAttribute("allEmp");
							for(int i=0;i<emps.size();i++){
								Employee emp = emps.get(i);
						 %>
						<tr class="row<%=i%2+1%>">
							<td><%= emp.getId() %></td>
							<td><%= emp.getName() %></td>
							<td><%= emp.getSalary() %></td>
							<td><%= emp.getAge() %></td>
							<td>
								<a href="delemp.do?id=<%=emp.getId()%>"
								   onclick="return confirm('是否确认删除<%=emp.getName()%>?')">删除</a>&nbsp;
								<a href="loademp.do?id=<%=emp.getId()%>">修改</a>
							</td>
						</tr>
						<%} %>					
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
		
