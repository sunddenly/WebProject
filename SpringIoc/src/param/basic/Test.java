package param.basic;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("paramBasic.xml");
		DataSource ds = (DataSource) ctx.getBean("ds");
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
}
