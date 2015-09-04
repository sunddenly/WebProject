<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<title>登录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
		<style>
			.tips{
				color:red;
			}
		</style>	
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp" %>	
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						登录
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
									<%
										String msg = 
										(String)request.getAttribute("login_error");
									 %>
									<span class="tips"><%=(msg == null ? "" : msg)%></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" 
							value="提交 &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
