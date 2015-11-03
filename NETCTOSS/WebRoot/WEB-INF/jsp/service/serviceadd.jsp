<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script type="text/javascript" src="/NetCTOSS/js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="/NetCTOSS/js/jquery.form.js"></script>
        <script language="javascript" type="text/javascript">
			$(document).ready(function(){
    			$('#submit').click(function(){
    				if(validatePwd()&&searchAccount()){
	            		$('#addFrom').ajaxSubmit(function(ok){
	                		var unixHost = $("#unixHost").val();
							var osUserName = $("#osUserName").val();
							if(ok){
								$("#save_result_info").text("保存成功！").attr("class","save_success");
								showResult();
							}else{
								$("#save_result_info").html("保存失败！"+unixHost+"已经开通过OS账号："+osUserName).attr("class","save_fail");
								var info = $("#save_result_info").html();
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
			
            //自动查询账务账号
            function searchAccount() {
                $("#loginName").val("");
            	$("#accountId").val("");
            				
            	var idcardNo = $("#idcardNo").val();
            	if(idcardNo == "") {
            		$("#idcard_no_msg").text("身份证不能为空.").addClass("error_msg");
            		return false;
            	}
            	
            	var reg = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
            	if(!reg.test(idcardNo)) {
            		$("#idcard_no_msg").text("请输入正确格式的身份证.").addClass("error_msg");
            		return false;
            	}else{
            		$("#idcard_no_msg").text("有效的身份证号码.").removeClass("error_msg");
            	}
            	var url = "/NetCTOSS/account/find";
            	$.post(
            		url,
            		{"idcardNo":idcardNo},      
            		function(data) {
            			if(data == "") {
            				$("#logname_no_msg").text("此身份证没有对应的账务账号.").addClass("error_msg");
            			} else if(data.status=="1"){
            				$("#logname_no_msg").text("此账务账号为暂停状态不能为其办理业务！").addClass("error_msg");
            			}else {
            				
            				$("#logname_no_msg").text("此账务账号为已开通可为其办理业务！").removeClass("error_msg");
            				$("#loginName").val(data.login_name);
            				$("#accountId").val(data.account_id);
            			}
            		}
            	);
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
            <img src="../images/logo.png" alt="logo" class="left"/>
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
                <li><a href="../service/service_list.html" class="service_on"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <!--保存操作的提示信息-->
            <div id="save_result_info" class="save_fail">保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。</div>
            <div ></div>
            <form action="/NetCTOSS/service/add" method="post" class="main_form" id="addFrom">
                <!--内容项-->
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" class="width180" id="idcardNo"/>
                    <input type="button" value="查询账务账号" class="btn_search_large" onclick="searchAccount()" />
                    <span class="required">*</span>
                    <div class="validate_msg_short" id="idcard_no_msg">没有此身份证号，请重新录入。</div>
                </div>
                <div class="text_info clearfix"><span>账务账号：</span></div>
                <div class="input_info">
                    <input type="hidden" name="account_id" id="accountId"/>
                    <input type="text" id="loginName" class="readonly" readonly/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="logname_no_msg">没有此账务账号，请重新录入。</div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select name="cost_id">
                    	<c:forEach items="${costs}" var="c">
	                        <option value="${c.cost_id}">${c.name}</option>
                    	</c:forEach>
                    </select>  
                </div> 
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" name="unix_host" id="unixHost" onblur="findOsUserName()" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="ip_msg" >15 长度，符合IP的地址规范</div>
                </div>                 
                <div class="text_info clearfix"><span>登录 OS 账号：</span></div>
                <div class="input_info">
                    <input type="text" name="os_username" id="osUserName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="hostMsg">8长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" name="login_passwd" id="pwd1"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password" id="pwd2" onblur="validatePwd()"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="pwd_msg">两次密码必须相同</div>
                </div>     
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="submit"/>
                    <input type="button" value="取消" class="btn_save" onclick="location.href='/NetCTOSS/service/list/*/*/*/-1/1'"/>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)加拿大达内IT培训集团公司 </span>
        </div>
    </body>
</html>
