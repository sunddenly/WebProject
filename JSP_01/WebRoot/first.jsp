<%@page import="java.util.*,java.text.*"
        contentType="text/html; charset=utf-8"
        pageEncoding="utf-8" %>

<html>
	<head>
	</head>
	<body>
	当前日期为：
		<table border=1px;>
			<%
				for(int i=0;i<20;i++){
			 %>
			<tr><td>
				<%= "hello" %>
			</td></tr>
			<%
				}
			 %>
			 <%
			 	SimpleDateFormat sdf = 
			 		new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			 	String time = sdf.format(new Date());
			  %>
			 <h1><%= time %></h1>
		</table>
	</body>
</html>