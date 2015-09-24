package test;

import java.io.IOException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;

public class TestSelectPartDept {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSession();
			Dept dept = new Dept();
			Map map = (Map)sqlSession.selectOne("findByIdp",81);
			System.out.println(map.get("deptno")+":"+map.get("dname"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
