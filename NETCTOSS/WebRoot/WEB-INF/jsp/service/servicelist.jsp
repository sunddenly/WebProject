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
        <script language="javascript" type="text/javascript">
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }else
                    detailDiv.style.display = "none";
            }
            //删除
            function deleteAccount() {
                var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //开通或暂停
            function setState() {
                var r = window.confirm("确定要开通此业务账号吗？");
                document.getElementById("operate_result_info").style.display = "block";
                
            }
            function doSearch(page){
            	var osUsername = $("#osUsername").val();
            	var unixHost = $("#unixHost").val();
            	var idcardNo = $("#idcardNo").val();
            	var status = $("#status").val();
            	//根据条件变量状态生成一个rest风格的查询的url
            	var url = "/NetCTOSS/service/list";
            	if(osUsername == ""){
            		url += "/*";
            	}else{
            		url += "/"+osUsername;
            	}
            	
            	if(unixHost==""){
            		url += "/*";
            	}else{
            		url += "/"+unixHost;
            	}
            	
            	if(idcardNo==""){
            		url += "/*";
            	}else{
            		url += "/"+idcardNo;
            	}
            	
            	url += "/"+status;
            	url += "/"+page;
            	window.location = url;//用js以get方式发送请求
            }
            //开启业务
            function startAccount(id){
            	var r = window.confirm("确定要开通此业务账号吗？");
            	var no = $("#no").html();
            	if(r){
	            	$.ajax({
	   					type: "POST",
					    url: "/NetCTOSS/service/start/"+id,
					    data: "no="+no,//{"no":no}
					    success: function(ok){
							var result = $("#operate_result_info span");
	                		var parent = $("#operate_result_info");
	                		if(ok){
	                			result.html("开通成功！");
	                			parent.attr("class","operate_success");
	                			parent.css("display","block");
	                		}else{
	                			parent.attr("class","operate_fail");
	                			result.html("开通失败！其业务账号为暂停状态。");
	                			parent.css("display","block");
	                		}
	   					}
					});
            	}
            }
            //暂停业务
            function pauseAccount(id){
            	var r = window.confirm("确定要暂停此业务账号吗？");
            	if(r){
	            	$.ajax({
	   					type: "PUT",
					    url: "/NetCTOSS/service/stop/"+id,
					    success: function(ok){
					    	var result = $("#operate_result_info span");
	                		var parent = $("#operate_result_info");
	                		if(ok){
	                			result.html("暂停成功！");
	                			parent.attr("class","operate_success");
	                			parent.css("display","block");
	                		}else{
	                			parent.attr("class","operate_fail");
	                			result.html("暂停失败！数据并发错误。");
	                			parent.css("display","block");
	                		}
	   					}
					});
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
            <form:form commandName="page">
                <!--查询-->
                <div class="search_add">                        
                    <div>OS 账号：
                    	<form:input path="os_username" id="osUsername" cssClass="width100 text_search"/>
                    </div>                            
                    <div>服务器 IP：
                    	<form:input path="unix_host" id="unixHost" cssClass="width100 text_search" />
                    </div>
                    <div>身份证：
                    	<form:input path="idcard_no" id="idcardNo" cssClass="text_search" />
                    </div>
                    <div>状态：
                        <form:select path="status" id="status">
                        	<form:option value="-1">全部</form:option>
                        	<form:option value="0">开通</form:option>
                        	<form:option value="1">暂停</form:option>
                        	<form:option value="2">删除</form:option>
                        </form:select>
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" onclick="doSearch(1)"/></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='/NetCTOSS/service/toAdd';" />
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="/NetCTOSS/images/close.png" onclick="location.href='/NetCTOSS/service/list/*/*/*/-1/1'" />
                    <span></span>
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务ID</th>
                        <th class="width70">账务账号ID</th>
                        <th class="width150">身份证</th>
                        <th class="width70">姓名</th>
                        <th>OS 账号</th>
                        <th class="width50">状态</th>
                        <th class="width100">服务器 IP</th>
                        <th class="width100">资费</th>                                                        
                        <th class="width200"></th>
                    </tr>
                    <c:forEach items="${services}" var="s">
	                    <tr>
	                        <td><a href="/NetCTOSS/service/${s.service_id}" title="查看明细">${s.service_id}</a></td>
	                        <td>${s.account_id}</td>
	                        <td id="no">${s.idcard_no}</td>
	                        <td>${s.real_name}</td>
	                        <td>${s.os_username }</td>
	                        <td>
	                        	<c:choose>
	                        		<c:when test="${s.status=='0'}">开通</c:when>
	                        		<c:when test="${s.status=='1'}">暂停</c:when>
	                        		<c:otherwise>删除</c:otherwise>
	                        	</c:choose>
							</td>
	                        <td>${s.unix_host}</td>
	                        <td>
	                            <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${s.cost_name}</a>
	                            <!--浮动的详细信息-->
	                            <div class="detail_info">
	                                ${s.cost_descr}
	                            </div>
	                        </td>                            
	                        <td class="td_modi">
	                        	<c:choose>
		                        	<c:when test="${s.status=='0'}">
		                        		<input type="button" value="暂停" class="btn_pause" onclick="pauseAccount(${s.service_id})" />
			                            <input type="button" value="修改" class="btn_modify" onclick="location.href='/NetCTOSS/service/${s.service_id}/toEdit';" />
			                            <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${account.account_id});" />                     
		                        	</c:when>
		                        	<c:when test="${s.status=='1'}">
		                        		<input type="button" value="开通" class="btn_pause" onclick="startAccount(${s.service_id})" />
			                            <input type="button" value="修改" class="btn_modify" onclick="location.href='/NetCTOSS/service/${s.service_id}/toEdit';" />
			                            <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(${account.account_id});" />                     
		                        	</c:when>
		                        	<c:otherwise>
		                        	</c:otherwise>
		                        </c:choose>
	                        </td>
	                    </tr>
                    </c:forEach>
                </table>                
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
                </div>                    
                <!--分页--> 
                <div id="pages">
                    <a href="javascript:doSearch(1);">首页</a>
                    <c:choose>
                		<c:when test="${page.page>1}">
		        	        <a href="javascript:doSearch(${page.page-1});">上一页</a>
                		</c:when>
                		<c:otherwise>
                			<a>上一页</a>
                		</c:otherwise>
                	</c:choose>
                	
                	<c:forEach var="i" begin="1" end="${page.totalPage}">
                		<c:choose>
                			<c:when test="${i==page.page}">
			                    <a href="javascript:doSearch(${i});" class="current_page">${i}</a>
                			</c:when>
                			<c:otherwise>
			                    <a href="javascript:doSearch(${i});">${i}</a>
                			</c:otherwise>
                		</c:choose>
                	</c:forEach>
                	
                	<c:choose>
                		<c:when test="${page.page<page.totalPage}">
		        	         <a href="javascript:doSearch(${page.page+1});">下一页</a>
                		</c:when>
                		<c:otherwise>
                			<a>下一页</a>
                		</c:otherwise>
                	</c:choose>
                    <a href="javascript:doSearch(${page.totalPage});">末页</a> 
                 </div>                 
            </form:form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>
