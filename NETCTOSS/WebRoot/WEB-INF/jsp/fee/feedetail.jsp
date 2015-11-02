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
                <li><a href="../fee/fee_list.html" class="fee_on"></a></li>
                <li><a href="../account/account_list.html" class="account_off"></a></li>
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
            <form:form action="" method="get" commandName="cost" cssClass="main_form">
            
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info">
                	<form:input path="cost_id" cssClass="readonly" readonly="true"/>
                </div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                	<form:input path="name" cssStyle="width300" cssClass="readonly" readonly="true"/>
                </div>
                <div class="text_info clearfix"><span>资费状态：</span></div>
                <div class="input_info">
                    <form:select path="status" cssClass="disabled readonly" disabled="true" readonly="true">
                    	<form:option value="0">开通</form:option>
                    	<form:option value="1">暂停</form:option>
                    </form:select>                  
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
					<form:radiobutton path="cost_type" value="1" label="包月" id="monthly" onclick="feeTypeChange(1);" />
                    <form:radiobutton path="cost_type" value="2" label="套餐" id="package" onclick="feeTypeChange(2);" />
                    <form:radiobutton path="cost_type" value="3" label="计时" id="timeBased" onclick="feeTypeChange(3);" />
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <form:input path="base_duration" cssClass="width100 readonly" readonly="true"/>
                    <span>小时</span>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <form:input path="base_cost" cssClass="width100 readonly" readonly="true"/>
                    <span>元</span>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <form:input path="unit_cost" cssClass="width100 readonly" readonly="true"/>
                    <span>元/小时</span>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info">
                	<form:input path="creatime" cssClass="readonly" readonly="true"/>
                </div>      
                <div class="text_info clearfix"><span>启动时间：</span></div>
                <div class="input_info">
                	<form:input path="startime" cssClass="readonly" readonly="true"/>
                </div>      
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <form:textarea path="descr" cssClass="width300 height70 readonly"  readonly="true"/>
                </div>                    
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='fee_list.html';" />
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
