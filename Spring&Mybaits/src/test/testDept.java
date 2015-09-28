package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.DeptMapperDao;
import com.hebut.entity.Dept;
import com.hebut.entity.Emp;

public class testDept {
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		DeptMapperDao dao = ac.getBean("deptMapperDao",DeptMapperDao.class);
//		List<Dept> list = dao.findAll();
//		for (Dept dept : list) {
//			System.out.println(dept.getDname()+","+dept.getDeptno()+","+dept.getLoc());
//		}
		List<Dept> list = dao.findAll1();
		for (Dept dept : list) {
			System.out.println(dept.getDname()+","+dept.getDeptno()+","+dept.getLoc());
			for(Emp emp : dept.getEmps()){
				System.out.println(emp.getEname());
			}
		}
	}
}
