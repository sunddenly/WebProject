package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	public static SqlSession getSession() throws IOException{
		String conf = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(conf);
		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = factoryBuilder.build(reader);
		SqlSession sqlSession = factory.openSession();
		return sqlSession;
	}
}
