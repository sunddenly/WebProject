<%@ page import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 引入标签库 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
</head>
<body>
	 <form:form action="/SpringMVC3/login/login.from" method="post" commandName="user">
	 	<form:errors path="*" cssStyle="color:red"/><br/>
	 	<hr/>
	 	用户名：
	 	<!-- 
	 	 HTML中的input:每次刷新后填入值清空
	 	<input type="text" name="username"/>
	 	 -->
	 	<!-- SpringMvc 中input  显示出事信息
	 	     每次刷新后填入值不清空
	 	-->
	 	<form:input path="username" value=""/><br/>
	 	<form:errors path="username" cssStyle="color:red"></form:errors>
	 	密码：<input type="password" name="password"/>
	 	<form:errors path="password" cssStyle="color:red"></form:errors><br/>
	 	电话号码：<input type="text" name="telePhone"/>
	 	<form:errors path="telePhone" cssStyle="color:red"></form:errors><br/>
	 	<input type="submit" value="登陆"/>
	 </form:form>
</body>
</html>