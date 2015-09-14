package spring.assembly.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.assembly.EmpService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app1.xml");
		EmpService emps = (EmpService) context.getBean("empService");
		System.out.println(emps.getDeptDao());
	}
}
