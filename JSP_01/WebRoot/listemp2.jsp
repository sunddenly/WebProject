<%@ page import="java.util.*,dao.*,entity.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

	<%-- --%>
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
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
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
							<td>薪水</td>
							<td>年龄</td>
							<td>操作</td>
						</tr>
						<%
							EmployeeDAO dao = new EmployeeDAO();
							List<Employee> emps = dao.findAll();
							for(int i=0;i<emps.size();i++){
								Employee emp = emps.get(i);
						 %>
						<tr class="row<%=i%2+1%>">
							<td><%= emp.getId() %></td>
							<td><%= emp.getName() %></td>
							<td><%= emp.getSalary() %></td>
							<td><%= emp.getAge() %></td>
						</tr>
						<%} %>					
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.html'"/>
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
		
