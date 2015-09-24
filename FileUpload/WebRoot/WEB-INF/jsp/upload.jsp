<%@ page import="java.util.*" 
    contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>File Up Load</title>
	</head>
	<body>
		<font color="red">${error }</font>
		<!-- multipart/form-data：以数据块的方式传输数据 -->
		<form action="upload2.from" method="post" enctype="multipart/form-data">
			<input type="file" name="file"><br/>
			<input type="submit" value="上传">
		</form>
		<form action="uploads.from" method="post" enctype="multipart/form-data">
			<input type="file" name="file"><br/>
			<input type="file" name="file">
			<input type="submit" value="上传">
		</form>
	</body>
</html>