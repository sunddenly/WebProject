#### 基于XML的Spring MVC搭建  
---
**XML构建Spring MVC：**
```
在搭建SpingMVC时，需要指定映射器handlerMapping和适配器HandlerAdapter以及视图解析器ViewRsolver
   1. handlerMapping：映射请求到后台处理器Controller
   2. HandlerAdapter：完成对处理器Controler中的具体方法调度
   3. ViewRsolver：将Conttroller返回的ModelAndview进行渲染
为了保证Spring MVC的健壮性，在Spring MVC 对上述组件提供了一些默认实现。当程序中，没有指定上述组件时将采用Spring提供的如下组件
   1. 默认ViewResolver组件：InternalResourceViewResolver
   2. 默认HandlerMapping组件：2个
      2.1 BeanNameUrlHandlerMapping：将请求的url直接和Bean的name进行匹配，匹配失败返回404
      2.2 DefaultAnnotationHandlerMapping：采用注解映射时使用，比如@RequestMaping，已过时
   3. 默认HandlerAdapter组件：3个
      3.1 HttpRequestHandlerAdapter：Handler实现HttpRequestHandler接口时有效            														
      3.2 SimpleControllerHandlerAdapter：Handler实现Controlelr接口时有效
      3.3 AnnotationMethodHandlerAdapter：Handler采用注解映射时有效，已过时
```
对于上述组件的配置，需要注意如下：  
- 对于HandlerAdapter组件   
    - XML模式：采用Spring MVC默认组件即可完成对Handler的匹配，所以配置该组件程序也能正常运行  
    - 注解模式：可采用Spring MVC默认提供的注解`适配`组件，也可显示配置RequestHandlerAdapter组件  
- 对于HandlerMapping组件   
    - XML模式：可采用Spring MVC提供的默认组件，也可显示配置SimpleControllerHandlerMapping组件  
    - 注解模式：可采用Spring MVC默认提供的注解`映射`配组件，也可显示配置RequestHandlerMapping组件  
- 对于ViewResolver组件  
    - 组件选取：可采用Spring MVC默认提供的InternalResourceViewResolver，也可显示配置其他组件  
    - 组件配置：  
        - 默认配置：可选取Spring MVC 默认配置：不提供视图前缀和后缀，在Controller中指定视图全部标识  
        - 指定配置：指定视图解析器的前缀和后缀，这样可以简化Controler对视图标识的处理    

---



           
           

