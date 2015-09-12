<%@ page import="java.util.*" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
		<title>jsp</title>
		<style>
			#d1{
				width:450px;
				height: 200px;
				background-color: black;
				margin-left: 400px;
				margin-top: 50px;
			}
			#d2{
				color:white;
				background-color: purple;
				height: 35px;
			}
			table{
				color:white;
				font-size: 24px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				setInterval(quoto,4000);
			});
			function quoto(){
				$.ajax({
					url:"quoto.do",
					type:"post",
					dataType:"json",
					success:function(data){
						$('#tb1').empty();
						for(i=0;i<data.length;i++){
							var s = data[i];
							$('#tb1').append(
								'<tr><td>'+s.code+'</td>'+
								'<td>'+s.name+'</td>'+
								'<td>'+s.price+'</td></tr>');
						}
					},
					error:function(){
						//服务器处理逻辑
					}
				});
			}
		</script>
	</head>
	<body>
		<div id="d1">
			<div id="d2">股票实时行情</div>
			<div id="d3">
				<table width="100%" cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<td>代码</td><td>名称</td><td>价格</td>
						</tr>
					</thead>
					<tbody id="tb1">
						
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>