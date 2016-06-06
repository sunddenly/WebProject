package mvc.webbasic;

import com.hebut.mvc.webbasic.NameOrPwdException;
import com.hebut.mvc.webbasic.NullParamException;
import com.hebut.mvc.webbasic.UserService;
import com.hebut.mvc.webbasic.ioc.JDBCDataSource;
import com.hebut.mvc.webbasic.ioc.MySqlUserDao;
import com.hebut.mvc.webbasic.ioc.User;
import com.hebut.mvc.webbasic.ioc.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by jxy on 2016/6/6.
 */
public class TestIOCAnnotation {
    String conf = "/config/spring/spring-mvc-webbasic.xml";
    ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
    //测试参数层：value注解，对JDBCDataSource Bean的注入
    @Test
    public void testPropertities() throws NameOrPwdException, NullParamException, SQLException {

        Properties prop = ac.getBean("db", Properties.class);
        JDBCDataSource ds = ac.getBean("jdbcDataSource", JDBCDataSource.class);
        System.out.println(prop);
        System.out.println(ds);
        System.out.println(ds.getConnection());
    }

    //测试通用层：Component注解，对JDBCDataSource Bean的注入
    @Test
    public void testJDBCDataSource() throws NameOrPwdException, NullParamException {

        JDBCDataSource dataSource = ac.getBean("jdbcDataSource", JDBCDataSource.class);
        MySqlUserDao userDao = ac.getBean("userDao", MySqlUserDao.class);
        System.out.println(dataSource);
        System.out.println(dataSource==userDao.getDataSource());
        User tom = userDao.findByName("Tom");
    }

    //测试持久层：Repository注解，对UserDao Bean的注入
    @Test
    public void testUserDaoBean() throws NameOrPwdException, NullParamException {
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        UserService userService = ac.getBean("userService", UserService.class);
        System.out.println(userDao);//有输出 说明容器正确创建了dao
        System.out.println(userDao==userService.getUserDao());//yrue表示userDao成功注入到UserService
        System.out.println(userService.login("Tom","123"));//NullPointerException
    }

    //测试业务层：Service注解，加载的UserService实例,默认ID为userService
    @Test
    public void testServiceAnnotation() throws NameOrPwdException, NullParamException {
        UserService userService = ac.getBean("userService", UserService.class);
        System.out.println(userService);//.UserService@73fae0f0
        //Service注解，仅仅用来加载一类，并不会自动为其属性注入实例
       //login方法依赖于UserDao，但此时还未注入
        System.out.println(userService.login("Tom","123"));//NullPointerException

    }
}
