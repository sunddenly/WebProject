package com.hebut.ioc;

import com.hebut.ioc.autodi.UserService;
import com.hebut.ioc.constrcutor.User;
import com.hebut.ioc.constrcutor.UserDao;
import com.hebut.ioc.setter.JDBCDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.Connection;
import java.sql.SQLException;


public class TestIOC {
    //自动参数注入
    @Test
    public void testUserServlce(){
        String conf = "/config/spring/ioc/spring-DI-autoDI.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        UserService userService = ac.getBean("userService", UserService.class);
        User user = userService.Login("蒋新宇","456");
        System.out.println(user);
    }
    //构造器参数注入
    @Test
    public void testMySqlUserDao(){
        String conf = "/config/spring/ioc/spring-DI-constructor.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user = userDao.findByName("LiSa");
        System.out.println(user);
    }
    //Setter注入测试
    @Test
    public void testJDBCDataSource() throws SQLException {
        String conf = "/config/spring/ioc/spring-DI-Setterr.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        JDBCDataSource ds = ac.getBean("dataSource", JDBCDataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
