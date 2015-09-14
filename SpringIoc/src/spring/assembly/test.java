package spring.assembly;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpService emps = (EmpService) context.getBean("empService");
		System.out.println(emps);
		System.out.println(emps.getDeptDao());
		System.out.println("===========2");
		EmpService emps2 = (EmpService) context.getBean("empService2");
		System.out.println(emps2);
		System.out.println("===========3");
		EmpService emps3 = (EmpService) context.getBean("empService3");
		System.out.println(emps3);
		
	}
}
