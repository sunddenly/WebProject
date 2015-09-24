<%@ page import="java.util.*" 
    contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Hello JSP</title>
	</head>
	<body style="font-size:30px;font-style: italic;">
		<c:if test="${fileUrl !=null}">
			<a href="${fileUrl}">查看</a>
		</c:if>
		<hr/>
		<ul>
			<c:forEach items="${fileUrls}" var="url">
				<li><a href="${url}">查看</a></li>
			</c:forEach>
		</ul>
	</body>
	
</html>