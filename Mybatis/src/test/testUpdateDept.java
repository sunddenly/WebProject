package test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;

public class testUpdateDept {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSession();
			Dept dept = new Dept();
			dept.setDeptno(80);
			dept.setDname("天津");
			dept.setLoc("南开大学");
			sqlSession.update("updateDept", dept);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
