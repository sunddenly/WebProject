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

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by jxy on 2016/6/6.
 */
public class TestMVCWebBasic {
    String conf = "/config/spring/spring-mvc-webbasic.xml";
    ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
    //测试UserService是否注入
    @Test
    public void testUserService() throws NameOrPwdException, NullParamException, SQLException {
        UserService service = ac.getBean("userService", UserService.class);
        System.out.println(service.login("Tom","123"));

    }

}
