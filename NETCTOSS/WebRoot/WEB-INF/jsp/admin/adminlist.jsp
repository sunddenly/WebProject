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
                }
                else
                    detailDiv.style.display = "none";
            }
            //document.getElementById("operate_result_info").style.display = "block";
            //重置密码
            function resetPwd() {
                var checkObjs = $("input[name='check_admin']:checked");
            	if(checkObjs.length == 0) {
            		alert("请至少选择一个管理员.");
            		return;
            	}
            	var ids = new Array();
            	for(var i=0;i<checkObjs.length;i++){
            		var trObj = $(checkObjs[i]).parent().parent();
            		var tdObj = $(trObj).children().eq(1);//获取admin_id
            		ids.push($(tdObj).text());
            	}
            	var str = ids.toString();
            	$.ajax({
                		url:"/NetCTOSS/admin/resetpwd",
                		type:"post",
                		data:{ids:str},
                		success:function(ok){
                			var result = $("#operate_result_info span");
                			var parent = $("#operate_result_info");
                			if(ok){
                				result.html("密码重置成功！");
                				parent.attr("class","operate_success");
                				parent.css("display","block");
                				
                			}else{
                				//document.getElementById("operate_result_info").style.display = "block";
                				parent.attr("class","operate_fail");
                				result.html("密码重置失败！数据并发错误");
                				parent.css("display","block");
                			}
                		}
                });
            }
            //刷新页面
            function refresh(){
            	$("#operate_result_info").css("display","none");
            	window.location="/NetCTOSS/admin/list/-1/*/1";
            }
            //删除
            function deleteAdmin(id) {
                var r = window.confirm("确定要删除此管理员吗？");
                if(r){
           			$.ajax({
                		url:"/NetCTOSS/admin/"+id,
                		type:"delete",
                		success:function(ok){
                			window.location="/NetCTOSS/admin/list/-1/*/1"
                		}
                	});     	
                }
            }
            //全选
            function selectAdmins(inputObj) {
            	//inputObj全选的checkbox
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type == "checkbox") {
                        inputArray[i].checked = inputObj.checked;
                    }
                }
            }
            function doSearch(page){
            	var moduleId = $("#moduleId").val();//选中的值
            	var roleName = $("#roleName").val();
            	//根据条件变量状态生成一个rest风格的查询的url
            	var url = "/NetCTOSS/admin/list";
            	if(moduleId == ""){
            		url += "/-1";
            	}else{
            		url += "/"+moduleId;
            	}
            	
            	if(roleName==""){
            		url += "/*";
            	}else{
            		url += "/"+roleName;
            	}
            	url += "/"+page;
            	window.location = url;//用js以get方式发送请求
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
                <li><a href="../admin/admin_list.html" class="admin_on"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
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
            <form:form commandName="page">
                <!--查询-->
                <div class="search_add">
                    <div>
                        模块：
                        <!-- id补血默认与path名相同 -->
                        <form:select path="moduleId" cssClass="select_search" id="moduleId">
                        	<form:option value="-1">全部</form:option>
                        	<c:forEach items="${pris}" var="p">
	                        	<form:option value="${p.id}">${p.name}</form:option>
                        	</c:forEach>
                        </form:select>
                    </div>
                    <div>角色：
                    	<form:input path="roleName" cssClass="text_search width200" id="roleName"/>
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" onclick="doSearch(1)"/></div>
                    <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
                    <input type="button" value="增加" class="btn_add" onclick="location.href='/NetCTOSS/admin/toAdd';" />
                </div>
                <!--删除和密码重置的操作提示-->
                <div id="operate_result_info" class="operate_fail">
                    <img src="/NetCTOSS/images/close.png" onclick="refresh()" />
                    <span>密码重置失败！数据并发错误</span><!--密码重置失败！数据并发错误。-->
                </div> 
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>  
                        <c:forEach items="${admins}" var="a">                    
	                        <tr>
	                            <td><input type="checkbox" name="check_admin"/></td>
	                            <td>${a.admin_id }</td>
	                            <td>${a.name }</td>
	                            <td>${a.admin_code }</td>
	                            <td>${a.telephone }</td>
	                            <td>${a.email }</td>
	                            <td>${a.enrolldate}</td>
	                            <td>
	                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${a.roles[0].name}</a>
	                                <!--浮动的详细信息-->
	                                <div class="detail_info">
	                                	${a.roleNames }
	                                </div>
	                            </td>
	                            <td class="td_modi">
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='/NetCTOSS/admin/${a.admin_id }/toEdit';" />
	                                <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin(${a.admin_id });" />
	                            </td>
	                        </tr>
                        </c:forEach>
                    </table>
                </div>  
                <!--分页-->
                <div id="pages">
                	<c:choose>
                		<c:when test="${page.page>1}">
		        	        <a href="${page.page-1}">上一页</a>
                		</c:when>
                		<c:otherwise>
                			<a>上一页</a>
                		</c:otherwise>
                	</c:choose>
                	<c:forEach var="i" begin="1" end="${page.totalPage}">
                		<c:choose>
                			<c:when test="${i==page.page}">
			                    <a href="${i}" class="current_page">${i}</a>
                			</c:when>
                			<c:otherwise>
			                    <a href="${i}">${i}</a>
                			</c:otherwise>
                		</c:choose>
                	</c:forEach>
                	<c:choose>
                		<c:when test="${page.page<page.totalPage}">
		        	        <a href="${page.page+1}">下一页</a>
                		</c:when>
                		<c:otherwise>
                			<a>下一页</a>
                		</c:otherwise>
                	</c:choose>
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
