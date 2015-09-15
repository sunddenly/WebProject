package param.expression;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("paramExpression.xml");
		Bar bar = (Bar) ctx.getBean("bar");
		System.out.println(bar.getBarName());
	}
}
