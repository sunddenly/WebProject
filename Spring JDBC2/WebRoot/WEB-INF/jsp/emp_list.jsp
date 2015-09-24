<%@ page import="java.util.*" 
    contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>EMP</title>
	</head>
	<body>
	 	<table>
	 		<tr>
	 			<td>编号</td><td>姓名</td><td>职位</td>工资</td>
	 		</tr>
	 		<c:forEach items="${emps}" var="e">
		 		<tr>
		 			<td>${e.empno}</td><td>${e.ename}</td><td>${e.job}</td><td>${e.sal}</td>
		 		</tr>
	 		</c:forEach>
	 	</table>
	</body>
</html>