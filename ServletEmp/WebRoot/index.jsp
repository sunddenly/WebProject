<%@ page language="java" 
	import="java.util.*" 
	contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>
  <head>
  </head>
 	<% String str = request.getAttribute("msg").toString(); %>
 	<%= str %>
  <body>
    This is my JSP page. <br>
  </body>
</html>
