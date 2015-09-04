<%@page import="java.util.*"
		pageEncoding="utf-8" 
		contentType="text/html;charset=utf-8" %>
<%
	String uname = (String) session.getAttribute("uname");
	if(uname==null){
		//session中没有登录信息
		//登陆页面
		response.sendRedirect("login.jsp");
		return;
	}
 %>
<html>
	<head>
		<title></title>	
	</head>
	<body>
		欢迎您：
		<%= uname %>
		<a href="logout.do">登出</a>
	</body>
</html>
