<%@ page import="java.util.*"
         contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
    <%--<%= request.getContextPath() %>--%>
    <h3>应用：${pageContext.request.contextPath}</h3>
     目录：wepapps/index.jsp:<br/>
     信息：${info}
</body>
</html>