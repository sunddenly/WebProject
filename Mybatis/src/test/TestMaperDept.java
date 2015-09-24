package test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;
import com.hebut.entity.myDept;
import com.hebut.mapper.DeptMapper;

public class TestMaperDept {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSession();
			DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);//动态生成实现类
			Dept dept = mapper.findById(81);
			System.out.println(dept.getDname());
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
