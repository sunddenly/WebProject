package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class TestSqlSession {
	public static void main(String[] args) throws IOException {
		SqlSession sqlSession = SqlSessionUtil.getSession();
		System.out.println(sqlSession);
		sqlSession.close();
	}
}
