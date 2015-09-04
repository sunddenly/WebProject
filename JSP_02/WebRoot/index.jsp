<%@ page import="java.util.*" 
	contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
  <head>
  		
  </head>
  
  <body>
  		<%
  			//在jsp页面中隐含request,response对象
  			String s = request.getAttribute("msg").toString();
  		 %>
  		 <p>
  		 	<h1><%= s %></h1>
  		 </p>
  </body>
</html>
