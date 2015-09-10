<%@ page import="java.util.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String msg = request.getAttribute("msg").toString();
		 %>
		 <h1><%= msg %></h1>
	</body>
</html>