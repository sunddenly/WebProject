<%@ page import="java.util.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme();
 %>
<html>
	<head>
	</head>
	<body>
		<h1>a1.jsp</h1>
		<a href="biz01/b1.jsp">相对路径</a>
		<a href="/JSP_02/biz01/b1.jsp">绝对路径</a>
		<a href="<%= request.getContextPath() %>/biz01/b1.jsp">动态绝对路径</a>
	</body>
</html>