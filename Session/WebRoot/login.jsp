<%@page import="java.util.*"
		pageEncoding="utf-8" 
		contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<title></title>	
	</head>
	<body>
		<form action="login.do" method="post">
			username:<input name="uname"/>
			<%= request.getAttribute("msg")==null?"":(String)request.getAttribute("msg") %>
			<br/>
			password:<input type="password" name="pwd"/>
			<br/>
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>
