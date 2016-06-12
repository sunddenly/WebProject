#### Spring MVC 的默认视图解析器
---
**项目结构**      
>XML Spring Defalut MVC    
>> 1. HandlerMapping：Spring MVC 默认不指定
>> 2. HandlerAdapter：Spring MVC 默认不指定
>> 3. ViewRsolver：Spring MVC 默认不指定

---

**默认视图解析器**   
```
   1. Spring MVC提供的默认视图解析器，没有设置前缀和后缀。
      1.1 默认前缀为：webapp/  默认资源后缀:.*
      1.2 处理器Controller返回的资源是：/webapp目录下的任意视图资源
   2. 若对视图解析器，设置视图前缀prefix和后缀suffix
      2.1 由Controller中返回的视图默认限定为：prefix路径下、suffix类型的视图资源,匹配格式;prefix+视图名+suffix
      2.2 若需要，访问其他位置和类型资源，可通过forward形式的转发和重定向来实现
          2.2.1 访问webapp/目录下的html类型资源，webapp/welcome/headpage.html
          2.2.2 转发：return "forward:/welcome/headpage.html"
          2.2.2 重定向：return "redirect:/welcome/headpage.html"
                        return new ModelAndView(new RedirectView("/AppName/welcome/headpage.html"))
```


