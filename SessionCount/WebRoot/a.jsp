<%@ page import="java.util.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 输出servletContext中绑定计数器，在页面中servletContext对应的隐含对象是application -->
		当前在线人数：<%= application.getAttribute("count") %>
		<br/>
		<a href="logout">注销</a>
	</body>
</html>