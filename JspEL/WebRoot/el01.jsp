<%@ page import="java.util.*, bean.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<%
			Course course = new Course();
			course.setCoureseId(1);
			course.setCourseName("java");
			User user = new User();
			user.setAge(10);
			user.setName("Lisa");
			user.setCourse(course);
			user.setInterest(new String[]{"eating","sleeping"});
			request.setAttribute("key", user);
			request.setAttribute("x", "age");
		 %>
		 <!-- 小脚本实现属性的输出 -->
		 <%
		 	User ul = (User) request.getAttribute("key");
		 	out.println(ul.getAge());
		 	out.println(ul.getName());
		 %>
		 <hr/>
		 <!-- 1. 使用EL访问绑定对象的属性 -->
		 <!-- pageContext,request,session,servletContext 
		      下面的key为上面定义的绑定名
		 -->
		 姓名：${key.name}<br/>
		 年龄：${key.age}<br/>
		 课程名：${key.course.courseName}
		 <hr/>
		 <!-- 2. 使用EL访问绑定对象的属性 -->
		 姓名：${key["name"]}<br/>
		 年龄：${key["age"]}<br/>
		 课程名：${key['course']['courseName']}<br/>
		 变值：${key[x]}<br/><!-- 此处是变量所以不加双引号 -->
		 爱好：${key.interest[0]}
		 <hr/>
		 <!-- 3. 指定访问范畴。若在指定范围没有找到，则不会去其他范围查找 -->
		 姓名：${requestScope.key["name"]}<br/>
		 年龄：${key["age"]}<br/>
		 变值：${key[x]}<br/><!-- 此处是变量所以不加双引号 -->
		 爱好：${key.interest[0]}
	</body>
</html>