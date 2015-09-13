<%@ page import="java.util.*,bean.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib 
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<html>
	<head>
		<title>Insert title here</title>
		<style type="text/css">
			.s1{color:red}
			.s2{color:blue}
		</style>
	</head>
	<body>
	<%
		Employee emp = new Employee();
		emp.setName("Lisa");
		emp.setGender("f");
		request.setAttribute("key", emp);
		//集合
		Employee e1 = new Employee("tom","m");
		Employee e2 = new Employee("Jerry","m");
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		request.setAttribute("list", emps);
	 %>
	 <!-- 1. if标签 -->
	 <c:if test="${key.gender=='f'}">女</c:if>
	 <c:if test="${key.gender=='m'}">男</c:if>
	 <hr/>
	 <c:if test="${key.gender=='f'}"
	       var="result" scope="request">女
	 </c:if>
	 <c:if test="${!result}">男</c:if>
	 <hr/>
	 <!-- 2. choose标签 -->
	 <c:choose>
	 	<c:when test="${key.gender=='m'}">男</c:when>
	 	<c:when test="${key.gender=='f'}">女</c:when>
	 	<c:otherwise>未知</c:otherwise>
	 </c:choose>
	 <hr/>
	 <!-- 3. forEach -->
	 <c:forEach var ="emp" items="${list}" varStatus="x">
	 <p class="s${x.index%2+1}">
	 	姓名：${emp.name}<br/>
	 	性别：${emp.gender}<br/>
	 	下标：${x.index}<br/>
	 	已访问过的元素：${x.count}<br/>
	 </p>
	 </c:forEach>
	</body>
</html>