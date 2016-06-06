package mvc.builder;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;

import java.util.Properties;

/**
 * Created by jxy on 2016/6/6.
 */
public class TestMVCBuilder {

    //测试handlerMapping映射
    @Test
    public void testHandlerMapping(){
        String conf = "/config/spring/spring-mvc-build-file.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        HandlerMapping hadlerMapping = ac.getBean("hadlerMapping", HandlerMapping.class);
        Properties urlMappings = ac.getBean("urlMappings", Properties.class);
        System.out.println(hadlerMapping);
        System.out.println(urlMappings);

        ViewResolver viewResolver = ac.getBean("viewResolver", ViewResolver.class);
        System.out.println(viewResolver);
    }
}
