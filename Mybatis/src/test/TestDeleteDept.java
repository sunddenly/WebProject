package test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;

public class TestDeleteDept {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSession();
			Dept dept = new Dept();
			sqlSession.delete("deleteDept",80);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
