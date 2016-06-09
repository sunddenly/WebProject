<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<!-- 导入JSP 核心标签-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"/>
<html>
    <head>
        <title>Success</title>
        <link rel="stylesheet" type="text/css" href="${base}statics/css/styles.css">
    </head>
    <body>
         <h6>${user.name}登录成功！</h6>
    </body>
</html>