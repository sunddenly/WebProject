<%@ page import="java.util.*" 
    contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>员工信息</title>
	</head>
	<body>
	 	<table border="1">
	 		<tr>
	 			<td>编号</td><td>姓名</td><td>职位</td><td>工资</td>
	 		</tr>
	 		<c:forEach items="${emps}" var="e">
		 		<tr>
		 			<td>${e.empno}</td><td>${e.ename}</td><td>${e.job}</td><td>${e.sal}</td>
		 			<td><a href="delete.from?id=${e.empno}">删除</a></td>
		 			<td><a href="update.from?id=${e.empno}">更新</a></td>
		 		</tr>
	 		</c:forEach>
	 	</table>
	</body>
</html>