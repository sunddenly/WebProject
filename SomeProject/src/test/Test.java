package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.some.service.EmpService;


public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("some.xml");
		EmpService service = (EmpService) ctx.getBean("empService");
		System.out.println(service);
		System.out.println(service.getDeptDao());
		System.out.println(service.getEmpDao());
		System.out.println(service.getDeptDao().getDs());
		System.out.println(service.getEmpDao().getDs());
	}
}
