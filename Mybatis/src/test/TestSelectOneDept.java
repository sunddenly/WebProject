package test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;

public class TestSelectOneDept {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSession();
			Dept dept = new Dept();
			dept = sqlSession.selectOne("findById",81);
			System.out.println(dept.getDname()+":"+dept.getDeptno());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
