package scan;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.Bar;
import com.hebut.Foo;
import com.hebut.Goo;

public class Test {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("moduleScan.xml");
//		Bar bar1 = (Bar) ctx.getBean("bar");
//		Bar bar2 = (Bar) ctx.getBean("bar");
//		
//		Foo foo1 = (Foo) ctx.getBean("foo");
//		Foo foo2 = (Foo) ctx.getBean("foo");
//		System.out.println(foo1);
//		System.out.println(foo2);
//		System.out.println(bar1);
//		System.out.println(bar2);
		Goo goo = (Goo) ctx.getBean("goo");
		System.out.println(goo.getBar());
	}
}
