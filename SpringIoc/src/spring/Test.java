package spring;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.callback.Goo;
import spring.createBean.Foo;
import spring.scope.Bar;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
		//向spring容器获取对象
		
//		Foo foo1 = (Foo) context.getBean("f1");
//		Foo foo2 = (Foo) context.getBean("f2");
//		Calendar c = (Calendar) context.getBean("c");
//		Bar b1 = (Bar) context.getBean("b");
//		Bar b2 = (Bar) context.getBean("b");
		Goo g = (Goo) context.getBean("g");
//		System.out.println(foo1);
//		System.out.println(foo2);
//		System.out.println(c);
//		System.out.println(b1);
//		System.out.println(b2);
		System.out.println(g);
		
	}
}
