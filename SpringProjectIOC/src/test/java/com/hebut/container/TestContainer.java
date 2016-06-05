package com.hebut.container;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

public class TestContainer {
    //指定依赖
    @Test
    public void testBeanDeply(){
        //实例化Spring容器示例
        String conf = "/config/spring/container/spring-deply.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        //获取ExampleBean对象
        ExampleBean bean1= ac.getBean("exampleBean", ExampleBean.class);
    }
    //测试Bean对象生命周期
    @Test
    public void testBeanLife(){
        //实例化Spring容器示例
        String conf = "/config/spring/container/spring-life.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        //获取ExampleBean对象
        ExampleBean bean1 = ac.getBean("exampleBean", ExampleBean.class);
        ExampleBean bean2 = ac.getBean("exampleBean", ExampleBean.class);
        System.out.println(bean1==bean2);//true
        //关闭Spring容器,AbstractApplicationContext定义了Spring容器的关闭方法
        AbstractApplicationContext ctx = (AbstractApplicationContext) ac;
        ctx.close();
    }

    //测试Bean对象作用域
    @Test
    public void testExampleBean(){
        //实例化Spring容器示例
        String conf = "/config/spring/container/spring-container.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        //获取ExampleBean对象
        ExampleBean bean1 = ac.getBean("exampleBean", ExampleBean.class);
        ExampleBean bean2 = ac.getBean("exampleBean", ExampleBean.class);
        System.out.println(bean1==bean2);//true
    }

    //测试实例化Spring容器示例
    @Test
    public void testCreateBean() {
        //classpath的文件路径,加载Spring容器
        String conf = "/config/spring/container/spring-container.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        System.out.println("name"+ac.getApplicationName());
        System.out.println(ac);
        //1. 构造器实例化
        Calendar cal1 = (Calendar) ac.getBean("calenderObj1");
        Calendar cal2 =  ac.getBean("calenderObj1",Calendar.class);
        System.out.println(cal1);
        //2. 静态工厂方法实例化
        Calendar cal3 = ac.getBean("calenderObj2", Calendar.class);
        System.out.println(cal2);
        //3. 实例工厂方法实例化
        Date dateObj = ac.getBean("dateObj", Date.class);
        System.out.println(dateObj);
    }
    @Test
    public  void testInitContext() {
        String conf = "/config/spring/container/spring-container.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        System.out.println(ac);
    }
}
