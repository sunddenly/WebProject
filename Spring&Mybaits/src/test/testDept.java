package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.DeptMapperDao;
import com.hebut.entity.Dept;

public class testDept {
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		DeptMapperDao dao = ac.getBean("deptMapperDao",DeptMapperDao.class);
		List<Dept> list = dao.findAll();
		for (Dept dept : list) {
			System.out.println(dept.getDname()+","+dept.getDeptno()+","+dept.getLoc());
		}
	}
}
