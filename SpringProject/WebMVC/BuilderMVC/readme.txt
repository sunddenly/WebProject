===========SPring IOC 组件======
spring-context
spring-core
spring-beans
spring-expression
commons-logging
=====mvc jar包=====
spring-web
spring-webmvc
=======启动Tomcat输出以下日志信息表示 SpringMVC配置成功========
信息: FrameworkServlet 'SpringMvc': initialization started
信息: Loading XML bean definitions from class path resource [config/spring/spring-mvc-build.xml]
信息: FrameworkServlet 'SpringMvc': initialization completed in 619 ms
=======Spring 配置文件加载通过Tomcat容器来加载===
有classpath:标识时，绝对路径中的/表示classpath
<servlet>
        <servlet-name>SpringMvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:/config/spring/spring-mvc-build.xml</param-value>
        </init-param>
      <load-on-startup>1</load-on-startup>
</servlet>
=============MVC注解==============================
<context:component-scan base-package="com.hebut.mvc.builder.annotation"/>
<mvc:annotation-driven/> SpringIOC不用开
@RequestMapping  请求路径映射
==========SQL===============
CREATE TABLE IF NOT EXISTS users(
   ID INT(7) PRIMARY KEY AUTO_INCREMENT,
   NAME VARCHAR(50),
   PWD VARCHAR(50),
	 PHONE VARCHAR(50)
)
INSERT INTO users
VALUES(null,'Tom','123','13587652145'),
(null,'Jim','456','18812766754')
===========================
客户端请求参数注入：
  Spring 自动注入 HttpServletRequest对象 到对应方法
  Spring 自动注入 表单数据 到对应方法
      @RequestParam 对数据名和方法参数名进行映射
  Spring 自动注入bean对象 user 到对应方法(参数较多时可采用，变量名和表单名对象)
服务端响应参数传输：
  ModelAndView new ModelAndView("jsp",hashMap)实现控制器向页面传值HttpServletRequest
  ModelMap model.addAttributes()到HttpServletRequest
  @ModelAttribute 注解数据传输到HttpServletRequest
======================================================
  三者都是将数据放入HttpServletRequest，@SessionAttributes("name")
  从HttpServletRequest查找相应的name数据，有的话就将他放入Session
  @SessionAttributes的，执行时机早于参数前的@ModelAttribute
=========================================================


