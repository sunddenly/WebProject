<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="/NetCTOSS/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/NetCTOSS/styles/global_color.css" />
        <script type="text/javascript" src="/NetCTOSS/js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="/NetCTOSS/js/jquery.form.js"></script>      
        <script language="javascript" type="text/javascript">
        	$(document).ready(function(){
    			$('#submit').click(function(){
    				if(validatePwd()){
	            		$('#pwdFrom').ajaxSubmit(function(ok){
							if(ok){
								$("#save_result_info").text("保存成功！").attr("class","save_success");
								showResult();
							}else{
								$("#save_result_info").html("保存失败,旧密码输入错误！").attr("class","save_fail");;
								showResult();
							}
	            		});
    				}
    			});
			});
			//保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                if (flag)
                	$("#save_result_info").css("display","block");
                else
                	$("#save_result_info").css("display","none");
            }
			//两次密码要相同
            function validatePwd(){
            	var pwd1 = $("#pwd1").val();
            	var pwd2 = $("#pwd2").val();
            	if(pwd1 != pwd2){
            		$("#pwd_msg").html("两次输入的密码不一致！").addClass("error_msg");
            		return false;
            	}else{
            		$("#pwd_msg").html("两次输入的密码一致.").removeClass("error_msg");
            		return true;
            	}
            }
        </script>    
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="/NetCTOSS/images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <li><a href="../index.html" class="index_off"></a></li>
                <li><a href="../role/role_list.html" class="role_off"></a></li>
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
                <li><a href="../account/account_list.html" class="account_off"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_on"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，旧密码错误！-->
            <form action="/NetCTOSS/user/ModiPwd" method="post" class="main_form" id="pwdFrom">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="oldpwd"/><span class="required">*</span>
                    <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password"  class="width200" name="newpwd" id="pwd1" /><span class="required">*</span>
                    <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="pwd1" id="pwd2" onblur="validatePwd()"/><span class="required">*</span>
                    <div class="validate_msg_medium" id="pwd_msg">两次新密码必须相同</div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="submit"/>
                    <input type="button" value="取消" class="btn_save" onclick="location.href='/NetCTOSS/login/toIndex'"/>
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>
