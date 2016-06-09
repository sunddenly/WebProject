<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"/>
<html>
    <head>
        <title>上传文件</title>
    </head>
    <body>
        ${error}
        <form action="${base}upload.form" method="post" enctype="multipart/form-data">
            <input type="file" name="file" />
            <input type="submit" value="提交">
        </form>
        <hr/>
        <form action="${base}uploads.form" method="post" enctype="multipart/form-data">
            <input type="file" name="file"/><br/>
            <input type="file" name="file"/>
            <input type="submit" value="提交"/>
        </form>
    </body>
</html>