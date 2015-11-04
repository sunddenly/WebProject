﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="/NetCTOSS//styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/NetCTOSS//styles/global_color.css" />
        <script type="text/javascript" src="/NetCTOSS/js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="/NetCTOSS/js/jquery.form.js"></script>
        <script language="javascript" type="text/javascript">
        	$(document).ready(function(){
    			$('#submit').click(function(){
	            		$('#updateFrom').ajaxSubmit(function(ok){
							if(ok){
								$("#save_result_info").text("资费修改成功。").attr("class","save_success");
								showResult();
							}else{
								$("#save_result_info").html("资费修改成失败，数据并发错误！").attr("class","save_fail");
								showResult();
							}
	            		});
    			});
			});
            //保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = $("#save_result_info")
                if (flag)
                    divResult.css("display","block");
                else
                    divResult.css("display","none");
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="/NetCTOSS//images/logo.png" alt="logo" class="left"/>
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
            <div id="save_result_info" class="save_fail">资费修改失败！数据并发错误。</div>
            <form:form id="updateFrom" action="/NetCTOSS/service/${service.service_id }" method="put" cssClass="main_form" commandName="service">
                <!--必填项-->
                <div class="text_info clearfix"><span>业务账号ID：</span></div>
                <div class="input_info">
                    <form:input path="service_id" cssClass="readonly" readonly="true"/>
                </div>
                <div class="text_info clearfix"><span>OS 账号：</span></div>
                <div class="input_info">
                    <form:input path="os_username" cssClass="readonly" readonly="true"/>
                </div>
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <form:input path="unix_host" cssClass="readonly" readonly="true" />
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <form:select path="cost_id">
                    	<c:forEach items="${costs}" var="c">
	                        <form:option value="${c.cost_id }">${c.name }</form:option>
                    	</c:forEach>
                    </form:select>
                    <div class="validate_msg_medium">请修改资费类型，或者取消修改操作。</div>                      
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="submit" />
                    <input type="button" value="取消" class="btn_save" onclick="location.href='/NetCTOSS/service/list/*/*/*/-1/1'" />
                </div>

                
                <p>业务说明：<br />
                1、修改资费后，点击保存，并未真正修改数据库中的数据；<br />
                2、提交操作到消息队列；<br />
                3、每月月底由程序自动完成业务所关联的资费；</p>
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
