<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="/NetCTOSS/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/NetCTOSS/styles/global_color.css" /> 
  		<script type="text/javascript" src="/NetCTOSS/js/jquery-1.11.1.js"></script>
  		<script type="text/javascript">
  			function doSubmit(){
  				//表单数据js检查
  				//表单提交
  				var name = $("#admin_code").val();
  				var password = $("#password").val();
  				var code = $("#code").val();
  				if(code == ""){
  					$("#codeError").html("验证码不能为空");
  				}
  				//表单数据格式检查
  				//发送请求
  				$.ajax({
  					url:"/NetCTOSS/login/login/"+code,
  					type:"get",
  					beforeSend:function(xhr){
  						//将账号密码放入到Http请求头部分
  						xhr.setRequestHeader("name",name);
  						xhr.setRequestHeader("password",password);
  					},
  					success:function(data){//data是服务器返回的json数据
  						var ok = data.login;
  						if(ok){//登陆成功进入index页面
  							window.location="/NetCTOSS/login/toIndex";
  						}else{
  							//用户登录未成功，将返回错信息提示
  							$("#codeError").html(data.codeError);
  							$("#error").html(data.error);
  							//刷新验证码
  							$("#codeImg").attr("src","/NetCTOSS/login/getCode/"+(new Date()).getTime());
  						}
  					}
  				});
  				//document.getElementById("loginFrom").submit();
  			}
  		</script>
    </head>
    <body class="index">
    	<div id="aaa"></div>
    	<form action="login.from" method="post" id="loginFrom">
	        <div class="login_box">
	            <table>
	                <tr>
	                    <td class="login_info">账号：</td>
	                    <td colspan="2"><input name="admin_code" id="admin_code" type="text" class="width150" /></td>
	                    <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
	                </tr>
	                <tr>
	                    <td class="login_info">密码：</td>
	                    <td colspan="2"><input name="password" id="password" type="password" class="width150" /></td>
	                    <td><span class="required">30长度的字母、数字和下划线</span></td>
	                </tr>
	                <tr>
	                    <td class="login_info">验证码：</td>
	                    <td class="width70"><input name="code" id="code" type="text" class="width70" /></td>
	                    <td><img id="codeImg" src="getCode/123" alt="验证码" title="点击更换" onclick='$("#codeImg").attr("src","/NetCTOSS/login/getCode/"+(new Date()).getTime());'/></td>  
	                    <td><span id="codeError" class="required"></span></td>              
	                </tr>            
	                <tr>
	                    <td></td>
	                    <td class="login_button" colspan="2">
	                        <a href="#" onclick="doSubmit()"><img src="/NetCTOSS/images/login_btn.png" /></a>
	                    </td>    
	                    <td><span id="error" class="required"></span></td>                
	                </tr>
	            </table>
	        </div>
    	</form>
    </body>
</html>
