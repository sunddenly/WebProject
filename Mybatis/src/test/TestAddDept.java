package test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;

public class TestAddDept {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSession();
			Dept dept = new Dept();
			dept.setDeptno(81);
			dept.setDname("北京");
			dept.setLoc("北京邮电大学");
			sqlSession.insert("addDept",dept);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			sqlSession.close();
		}
	}
}
