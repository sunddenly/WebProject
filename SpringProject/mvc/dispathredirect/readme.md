#### Spring MVC 转发/重定向
--- 
**程序配置**
>前置控制：DispathcerServlet   *.form   
>应用名称：/mvc-req  
>视图解析：prefix："/webapp/WEB-INF/views"  
　　　　　 suffix：".jsp"  

---
##### Spring MVC 转发  
**普通转发：**访问视图解析器指定资源，格式：prefix+视图名称+suffix
``` java
1. 相对路径：
   return new ModelAndView("index",data); ===> "/webapp/WEB-INF/views" + "index" + ".jsp"
   return "index"                         ===> "/webapp/WEB-INF/views" + "index" + ".jsp"
2. 绝对路径：
   return new ModelAndView("/pages/first",data); ===> "/webapp/WEB-INF/views" + "/pages/first" + ".jsp"
   return "/pages/first";                        ===> "/webapp/WEB-INF/views" + "/pages/first" + ".jsp"
```
**forward转发：**访问应用下的任意资源,此时必须指定视图的`名称`和`后缀`
``` java
1. 访问视图解析器指定资源
    return "forward:/WEB-INF/views/hello.jsp"  =====>    "wepapps/WEB-INF/view/hello.jsp"
2. 访问非视图解析器资源
    return "forward:/index.jsp"                =====>    "/webapp/index.jsp"
	return "forward:/WEB-INF/web-info.jsp";    =====>    "wepapps/WEB-INF/web-info.jsp"
3. 访问应用程序的某个Controller资源
    return "forward:/spring/index.form";      =====>    ..../mvc-req/spring/index.form  ==> "/webapp/index.jsp"
```	 
#### Spring 重定向
**ModelAndView重定向**
``` java
RedirectView view = new RedirectView("/mvc-req/spring/index.form");
return new ModelAndView(view,map);	           ====>     "/webapp/index.jsp"
``` 
**String重定向**
``` java
1. **重定向WEB-INF资源：**在WEB-INF下的资源浏览器无法直接访问，需要通过请求实现
   return "redirect:/spring/index.form";          =====>    ..../mvc-req/spring/index.form  ==> "/webapp/index.jsp"
2. **重定向非WEB-INF资源：**非WEB-INF资源浏览器可以直接从服务器上获取到，访问方式如下
   return "redirect:/welcome/headpage.jsp";      ====wepapps/welcome/headpage.jsp:
```
#### Servlet转发/重定向
---

> Spring的转发和重定向，是在原始Servlet转发和重定向技术基础上实现的，两者相似之处如下  
>> request   转发     ===>  "forward:/url"   
>> responsse 重定向   ===>   return new ModelAndView(new RedirectView("/mvc-req/spring/index.form"))  

#### Servlet转发：
**转发请求：**
``` java
RequestDispatcher dispatcher = req.getSession().getServletContext().getRequestDispatcher("/spring/index.form");
dispatcher.forward(req,res);
```
**转发视图：**
``` java
RequestDispatcher dispatcher = req.getSession().getServletContext().getRequestDispatcher("/WEB-INF/web-info.jsp");
dispatcher.forward(req,res);
```
#### Servlet重定向
``` java
req.getSession().setAttribute("info","servlet 重定向");
res.sendRedirect("/mvc-req/spring/index.form");
```
