<%
	Object obj = session.getAttribute("user");
	if(obj == null){
		response.sendRedirect("login.jsp");
		return;
	}
 %>

<h1>main...</h1>
<%
	System.out.println("some code...");
 %>
