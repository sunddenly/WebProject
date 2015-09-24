package test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hebut.entity.Dept;
import com.hebut.entity.myDept;
import com.hebut.mapper.DeptMapper;

public class TestMaperMyDept {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSession();
			DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);//动态生成实现类
			List<myDept> list = mapper.findAll1();
			for (myDept myDept : list) {
				System.out.println(myDept.getNo()+","+myDept.getName()+","+myDept.getLoc());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
