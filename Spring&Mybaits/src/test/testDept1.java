package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.DeptMapperDao;
import com.hebut.entity.Dept;
import com.hebut.entity.Emp;

public class testDept1 {
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		DeptMapperDao dao = ac.getBean("deptMapperDao",DeptMapperDao.class);
//		Dept dept = dao.findById(20);
//		System.out.println(dept.getDname());
//		//调用getEmps可以触发嵌套查询语句
//		for(Emp emp : dept.getEmps()){
//			System.out.println(emp.getEname());
//		}
		Dept dept = dao.findById1(10);
		for(Emp emp : dept.getEmps()){
			System.out.println(emp.getEname());
		}
	}
}
