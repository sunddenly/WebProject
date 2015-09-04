<%@page contentType="text/html;charset=utf-8" 
pageEncoding="utf-8"%>
<%@page import="java.util.*,java.text.*" %>
<div id="header">
	<div id="rightheader">
		<p>
			<%
			Date date = new Date();
			SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd");
		 	%>
			日期:<%=sdf.format(date)%>
			<br />
		</p>
	</div>
	<div id="topheader">
		<h1 id="title">
			<a href="#">用户管理</a>
		</h1>
	</div>
	<div id="navigation">
	</div>
</div>