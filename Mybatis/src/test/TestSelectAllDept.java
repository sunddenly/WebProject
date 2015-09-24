package test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;

public class TestSelectAllDept {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSession();
			List<Dept> selectList = sqlSession.selectList("findAll");
			for (Dept dept : selectList) {
				System.out.println(dept.getDname()+":"+dept.getDeptno());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
