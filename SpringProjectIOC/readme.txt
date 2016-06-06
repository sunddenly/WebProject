该项目包括如下内容：
   1. Spring容器的初始化，以及Spring容器加载Bean的方法
      1.1 Spring 容器，可由BeanFactory/ApplicationContext抽象表示，通过他们可以加载并初始化Bean
      1.2 Spring容器加载/初始化bean的方式包括
          1.2.1 在Spring容器的配置文件中加载：xxx-application.xml
          1.2.2 在配置文件设置自动扫描，将包含注解的所有Bean一次性加载到Spring容器中

   2. Spring容器对加载Bean进行管理，即维护多个个bean的之间的关系
      2.1 对Bean属性进行注入
          2.3.1 setter注入
          2.3.2 constrctor注入
          2.3.3 autowaired注入：byType/byName
      2.2 对Bean进行参数注入，该部分应该属于Setter注入的一个分支，将一些基本变量、集合、自定义bean进行注入
          2.2.1 基本类型注入
          2.2.2 集合类型注入
          2.2.3 空字符串、null值注入
============================================
    1. 自动组件扫描：优化的是第一部分，通过扫描的方式，将Bean更加方便加载到容器，并实例化
                      这样就不用，每次定义JavaBean后，还要在容器配置文件定义一次，再能加载到容器
                      这样，只需在JavaBean上加上注解即可,即可实现Bean到容器的加载
       1.1 自动扫描的Bean名称
       1.2 指定扫描后的Bean名称
       1.3 指定扫描Bean的作用域,以及互相的装配方式
           @Resource
           @Autowired/@Qualifier
            @Inject/@Named
       1.4 ---如何指定作用域为session
    2. 自动装配：自动组件扫描基础上的进一步优化，此时优化的是第二部分，对加载到容器中的Bean的管理
                 通过注解的方式，实现Bean之间的依赖关系、作用域等
=====package说明========================
IOC====>对容器Bean的依赖管理部分，DI
papram==>参数注入部分
container===>为Spring容器、以及Spring容器加载Bean

==============
Spring 注解做了两件事情
1. 声明组件，加载组件到Spring容器
2. 依赖管理，指定组件的依赖关系，Bean之间的组合
===========SPring IOC 组件======
spring-context
spring-core
spring-beans
spring-expression
commons-logging



