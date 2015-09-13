/*创建xhr对象*/
function getXhr(){
	var xhr = null;
	//判断浏览器是否支持XMLHttpRequest对象
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}else{
		xhr = new ActiveXObject('Microsoft.XMLHttp');
	} 
	return xhr;
}

/*根据传入的id值，返回对应的DOM对象*/
function $(id){
	return document.getElementById(id);
}





