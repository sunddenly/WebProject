<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title></title>
    </head>
    <body>
    <div>文件列表</div>
        <c:if test="${fileUrl!=null}">
            <a href="${fileUrl}">查看</a>
        </c:if>
        <hr/>
        <ul>
            <c:forEach items="${fileUrls}" var="url">
                <li><a href="/encodeURI(${url})">查看</a></li>
            </c:forEach>
        </ul>
    </body>
</html>