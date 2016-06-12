#### Spring MVC 案例
**项目结构**  
> Spring MVC    
>> 1. XMLDefultBuild: 基于XML的项目Spring MVC项目搭建  
      1.1 基于默认HandlerMapping组件：mvc-defalult-xmlbuilder.xml  
      2.2 基于简单SimpleControllerHandlerMaping组件：mvc-defalult-simpliebuilder.xml  
>> 2. XMLXMLDefultBuildView：除了Controller组件，均全部采用SpringMVC默认组件  
>> 3. DispatchRedirect：测试Spring MVC和Servlet组件的转发和重定向  
      3.1 基于Spring的转发重定向  
          转  发：return "ModelAndView"; return "视图名称"; return "/.../视图名"; return "forward:/视图路径"  
          重定向：return "new ModelAndView(new RedirectView()";  return "redirect:/appname/视图路径或者controller请求";  
      3.2 Servlet：转发和重定向
>> 4. DataProcess