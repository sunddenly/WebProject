//jQuery好处：内容与控制彻底分离
/**
 * document加载完dom树的操作
 * $(document).ready()
 * $(function(){
 * 		load加载事件
 * 		给制定元素注册事件
 * 		$('#d1').bind('click','function(){}');
 * 		$('#d1').click(function(){});
 *      描述：
 *          1. 让'd1'元素监听单机事件
 *          2. 当捕获到单机事件，异步回调function(){}匿名方法
 * 	 });
 * 针对load事件添加的响应代码可以添加到多个ready的匿名方法中
 * jQuery会将多个read()合并到一起，顺序执行
 */
$(function (){
    $('#d1').click(function(){
        $(this).html('Hello Ajax');
    });
    $('#d2').click(function(){
    	alert($(this).html());
    });
});
$(function (){
	$('#d21').click(function(e){
		alert($(this).html());
        //阻止事件冒泡
        e.stopPropagation();
        //显示事件发生时的横纵坐标
        alert(e.pageX+","+ e.pageY);
        //显示发生事件的对象信息
        /**
         * e.target:指的是发生事件的根本源头,不会变. 事件产生端
         * e.currentTarget:回合事件的冒泡而改变，传到哪个target就是哪个target，事件接收端
         */
        alert($(e.target).attr('id')+" "+ $(e.currentTarget).attr('id'));
        
	});
});
$(function (){
	$('#d3').hover(
			function() {
				//鼠标移入时触发
				$(this).addClass("s1");
			},
			function() {
				//鼠标移出时触发
                $(this).removeClass("s1");
			});
});