package com.hebut.ioc;

import com.hebut.ioc.autodi.UserService;
import com.hebut.ioc.autoscan.Bar;
import com.hebut.ioc.autoscan.Foo;
import com.hebut.ioc.autoscan.Goo;
import com.hebut.ioc.constrcutor.User;
import com.hebut.ioc.constrcutor.UserDao;
import com.hebut.ioc.setter.JDBCDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;


public class TestAutoScan {
    //自动参数注入
    @Test
    public void testAtuoScan(){
        String conf = "/config/spring/ioc/spring-DI-autoScan.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        //singleton模式
		Bar bar1 =  ac.getBean("bar",Bar.class);
		Bar bar2 =  ac.getBean("bar",Bar.class);
        System.out.println(bar1==bar2);
        //protoType模式,指定加载Bean名称
		Foo foo1 = ac.getBean("fooName",Foo.class);
		Foo foo2 = ac.getBean("fooName",Foo.class);
        System.out.println(foo1==foo2);
        //默认模式
        Goo goo1 = ac.getBean("goo",Goo.class);
        Goo goo2 = ac.getBean("goo",Goo.class);
        System.out.println(goo1.getBar());
        System.out.println(goo1==goo2);
    }

}
