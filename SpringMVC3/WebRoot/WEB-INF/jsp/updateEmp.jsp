<%@ page import="java.util.*" 
    contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Update Emp</title>
	</head>
	<body>
		<form:form commandName="emp">
		 	员工名：<form:input path="name"></form:input><br/>
		 	年龄：<form:input path="age"></form:input><br/>
		 	性别：<form:radiobutton path="sex" value="M" label="男"/>
		 		<form:radiobutton path="sex" value="F" label="女"/>
		 	<br/>
		 	简介：<form:textarea path="descr"></form:textarea><br/>
		 	所在城市：<form:radiobuttons path="city" items="${cityMap }"/><br/>
		 	<form:select path="city" items="${cityMap }"></form:select><br/>
		 	最喜爱的运动：
		 	<form:select path="favor">
		 		<form:option value="1">爬山</form:option>
		 		<form:option value="2">游泳</form:option>
		 		<form:option value="3">篮球</form:option>
		 		<option value="4">蹦极</option>
		 		<option value="4">-请选择-</option>
		 		<form:options items="${cityMap }"></form:options>
		 	</form:select><br/>
		 	兴趣爱好：
		 	<form:checkbox path="favs" value="a" label="上网"/>
		 	<form:checkbox path="favs" value="b" label="聊天"/><br/>
		 	<form:checkboxes items="${cityMap }" path="cities"/>
		</form:form>
	</body>
</html>