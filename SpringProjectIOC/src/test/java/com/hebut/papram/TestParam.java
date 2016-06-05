package com.hebut.papram;


import com.hebut.ioc.constrcutor.User;

import com.hebut.ioc.param.collect.MessageBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class TestParam {
    //集合参数注入
    @Test
    public void testParamCollect(){
        String conf = "/config/spring/param/spring-ParamDI-collect.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        MessageBean m = (MessageBean) ac.getBean("m1");
        m.execute();
        System.out.println(m.getSomeList().getClass().getName());
        System.out.println(m.getSomeSet().getClass().getName());
        System.out.println(m.getSomeMap().getClass().getName());
    }
    //基本参数注入
    @Test
    public void testParamBasic() throws SQLException {
        String conf = "/config/spring/param/spring-ParamDI-basic.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        DataSource ds = ac.getBean("ds", DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }


}
