<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="/NetCTOSS/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/NetCTOSS/styles/global_color.css" />
        <script type="text/javascript" src="/NetCTOSS/js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="/NetCTOSS/js/jquery.form.js"></script>
        <script type="text/javascript" src="/NetCTOSS/js/init.js"></script>
        <script language="javascript" type="text/javascript">
        	// wait for the DOM to be loaded 
			$(document).ready(function() { 
				// bind 'updateForm' and provide a simple callback function 
				$('#updateForm').ajaxForm(function(ok) { 
					var saveResult = $("#save_result_info");
					if(ok){
						saveResult.html("保存成功！");
						saveResult.attr("class","save_success");
						//saveResult.css("display","block");
						$("#main").animate({scrollTop:0}, 500);
						showResult();
					}else{
						saveResult.html("保存失败！");
						saveResult.attr("class","save_fail");
						//saveResult.css("display","block");
						$("#main").animate({scrollTop:0}, 500);
						showResult();
					}
				}); 
			}); 
            //保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = $("#save_result_info");
                if (flag)
                    divResult.css("display","block");
                else
                    divResult.css("display","none");
            }

            //显示修改密码的信息项
            function showPwd(chkObj) {
                if (chkObj.checked)
                    document.getElementById("divPwds").style.display = "block";
                else
                    document.getElementById("divPwds").style.display = "none";
            }
            //提交表单信息
            function doSubmit(){
            	
            	$("#updateForm").submit();
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
                <li><a href="../account/account_list.html" class="account_on"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">  
            <!--保存成功或者失败的提示消息-->          
            <div id="save_result_info" class="save_fail">保存失败，旧密码错误！</div>
            <form:form action="/NetCTOSS/account/${account.account_id}" commandName="account" method="put" cssClass="main_form" id="updateForm">
                    <!--必填项-->
                    <div class="text_info clearfix"><span>账务账号ID：</span></div>
                    <div class="input_info">
                        <form:input path="account_id" cssClass="readonly" readonly="true"/>
                    </div>
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <form:input path="real_name"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">20长度以内的汉字、字母和数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>身份证：</span></div>
                    <div class="input_info">
                        <form:input path="idcard_no" cssClass="readonly" readonly="true"/>
                    </div>
                    <div class="text_info clearfix"><span>登录账号：</span></div>
                    <div class="input_info">
                        <form:input path="login_name" cssClass="readonly" readonly="true"/>    
                        <!--                
                        <div class="change_pwd">
                            <input id="chkModiPwd" type="checkbox" onclick="showPwd(this);" />
                            <label for="chkModiPwd">修改密码</label>
                        </div>
                        -->
                    </div>
                    <!--修改密码部分-->
                    <!--
                    <div id="divPwds">
                        <div class="text_info clearfix"><span>旧密码：</span></div>
                        <div class="input_info">
                            <input type="password"  />
                            <span class="required">*</span>
                            <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                        </div>
                        <div class="text_info clearfix"><span>新密码：</span></div>
                        <div class="input_info">
                            <input type="password"  />
                            <span class="required">*</span>
                            <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                        </div>
                        <div class="text_info clearfix"><span>重复新密码：</span></div>
                        <div class="input_info">
                            <input type="password"  />
                            <span class="required">*</span>
                            <div class="validate_msg_long">两次密码必须相同</div>
                        </div>  
                    </div>      
                    -->             
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <form:input path="telephone"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">正确的电话号码格式：手机或固话</div>
                    </div>
                    <div id="save_result_info" class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                    <div id="save_result_info" class="input_info">
                        <form:input path="recommenderIdcardno"/>
                        <div class="validate_msg_long error_msgs">正确的身份证号码格式</div>
                    </div>
                    <div class="text_info clearfix"><span>生日：</span></div>
                    <div class="input_info">
                        <form:input path="birthdate" cssClass="readonly" readonly="true"/>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <form:input path="email" cssClass="width200"/>
                        <div class="validate_msg_medium">50长度以内，合法的 Email 格式</div>
                    </div> 
                    <div class="text_info clearfix"><span>职业：</span></div>
                    <div class="input_info">
	                    <form:select path="occupation">
	                    	<form:option value="干部">干部</form:option>
	                    	<form:option value="学生">学生</form:option>
	                    	<form:option value="技术人员">技术人员</form:option>
	                    	<form:option value="其他">其他</form:option>
	                    </form:select>                           
                    </div>
                    <div class="text_info clearfix"><span>性别：</span></div>
                    <div class="input_info fee_type">
                         <form:radiobutton path="gender" name="gender"  value="f" label="女"/>
	                   	 <form:radiobutton path="gender" name="gender"  value="m" label="男"/>
                    </div> 
                    <div class="text_info clearfix"><span>通信地址：</span></div>
                    <div class="input_info">
                        <form:input path="mailaddress" cssClass="width350"/>
                        <div class="validate_msg_tiny">50长度以内</div>
                    </div> 
                    <div class="text_info clearfix"><span>邮编：</span></div>
                    <div class="input_info">
                        <form:input path="zipcode"/>
                        <div class="validate_msg_long">6位数字</div>
                    </div> 
                    <div class="text_info clearfix"><span>QQ：</span></div>
                    <div class="input_info">
                        <form:input path="qq"/>
                        <div class="validate_msg_long">5到13位数字</div>
                    </div>                
                    <!--操作按钮-->
                    <div class="button_info clearfix"><!-- onclick="showResult();" -->
                        <input type="submit" value="保存" class="btn_save" />
                        <input type="button" value="取消" class="btn_save" onclick="location.href='/NetCTOSS/account/list/*/*/*/-1/1';"/>
                    </div>
                </form:form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)加拿大达内IT培训集团公司 </span>
        </div>
    </body>
</html>
