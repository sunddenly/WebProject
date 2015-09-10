function getXhr() {
	var xhr = null;
	if(window.XMLHttpRequest){
		xhr =  new XMLHttpRequest();
	}else{
		xhr = ActiveXObject("Microsoft.XMLHttp");
	}
	return xhr;
}
//获取dom对象
function $(id) {
	return document.getElementById(id);
}
//获取dom对象值
function $F(id) {
	return $(id).value;
}