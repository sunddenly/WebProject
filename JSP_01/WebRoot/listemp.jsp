<%@ page import="dao.*,entity.*,java.util.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//通过dao查询员工信息
	EmployeeDAO dao = new EmployeeDAO();
	List<Employee> emps = dao.findAll();
 %>
<html>
	<head>
		<style type="text/css">
			.row1{background-color: #E4E4F1}
			.row2{background-color: #FBD10A}
		</style>
	</head>
	<body>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>编号</td>			
				<td>姓名</td>			
				<td>薪资</td>			
				<td>年龄</td>			
			</tr>
			<% for(int i=0;i<emps.size();i++) {
				Employee emp = emps.get(i);
			%>
			<tr class="row<%= i%2+1 %>">
				<td><%= emp.getId() %></td>						
				<td><%= emp.getName() %></td>						
				<td><%= emp.getSalary() %></td>						
				<td><%= emp.getAge() %></td>						
			</tr>
			<% } %>
		</table>
	</body>
</html>