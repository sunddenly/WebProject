package test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;

public class TestSplitPage {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSession();
			//定义一个分页器,基于内存分页
			RowBounds rowBounds = new RowBounds(0,3);
			List<Dept> selectList = sqlSession.selectList("findAll",null,rowBounds);
			for (Dept dept : selectList) {
				System.out.println(dept.getDname()+":"+dept.getDeptno());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
