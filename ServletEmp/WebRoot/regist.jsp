<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<title>注册</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
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
						注册
					</h1>
					<form action="regist.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
									<%
										String msg2 = (String)request.getAttribute("regist_error");
									 %>
									<span class="tips"><%=(msg2 == null ? "" : msg2)%></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
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
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="gender" value="男" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="gender" value="女"/>
								</td>
								<tr>
									<td valign="middle" align="right">
										验证码：
										<img id="num" alt="" src="code"/>
										<a href="javascript:;" onclick="document.getElementById('num').src = 'code?'+(new Date()).getTime()">换一张</a>
									</td>
									<td valign="middle" align="right">
										<input type="text" class="inputgri" name="incode" />
										<span class="tips">
											<%= request.getAttribute("checkmsg")==null?"":request.getAttribute("checkmsg") %>
										</span>
									</td>
								</tr>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="提交 &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
	</body>
</html>
