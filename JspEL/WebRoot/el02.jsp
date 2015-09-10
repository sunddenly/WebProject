<%@ page import="java.util.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
	<%
		request.setAttribute("num", "12");
		request.setAttribute("str", "abc");
		request.setAttribute("x", "");
		request.setAttribute("y", new ArrayList());
		request.setAttribute("z", null);
	 %>
		<!-- 1. 算数运算 -->
		${1+1}<br/>
		${"100"+"200"}<br/>
		<hr/>
		<!-- 2. 逻辑运算 -->
		${1<2}<br/>
		${1==2}<br/>
		${1 eq 2}<br/>
		${requestScope.num eq 12}<br/>
		${requestScope.str eq "abc"}<br/><!-- abc必须加引号，否则认为他是变量 -->
		<hr/>
		<!-- 4. 判空运算 -->
		空白字符串：${empty x}<br/>
		空集合：${empty y}<br/>
		空引用：${empty z}<br/>
		无绑定名：${empty xxx}<br/>
		<hr/>
		<!-- 4. 获取请求参数值 -->
		请求参数：${param.name}<br/>
		请求参数：${paramValues.city}<br/>
		<hr/>
	</body>
</html>