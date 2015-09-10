<%@ page import="java.util.*,dao.*,entity.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%> 

<c:if test="${uname==null }">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p> 
							2015-9-6<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
						<a href="logout.do">注销</a>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami"></p>
					<h1>Welcome!</h1>
					<table class="table">
						<tr class="table_header">
							<td>编号</td>
							<td>姓名</td>
							<td>工资</td>
							<td>年龄</td>
							<td>操作</td>
						</tr>
						 <c:forEach var="emp" items="${allEmp}" varStatus="x">
							<tr class="row${x.index%2+1}">
								<td>${emp.id}</td>
								<td>${emp.name}</td>
								<td>${emp.salary}</td>
								<td>${emp.age}</td>
								<td>
									<a href="delemp.do?id=${emp.id}"
									   onclick="return confirm('是否确认删除${emp.name}?')">删除</a>&nbsp;
									<a href="loademp.do?id=${emp.id}">修改</a>
								</td>
							</tr>					
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
		
