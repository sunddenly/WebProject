package case1;

import javax.faces.application.Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.bcel.internal.util.ClassPath;

public class Test {
	@org.junit.Test
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		AddEmpService aemps = (AddEmpService) context.getBean("addEmpService");
		System.out.println(aemps);
		aemps.getDao().findAll();
	}
}
